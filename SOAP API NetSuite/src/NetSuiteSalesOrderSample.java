package com.netsuite.webservices.samples;

import com.netsuite.suitetalk.client.v2019_2.WsClient;
import com.netsuite.suitetalk.proxy.v2019_2.lists.relationships.Customer;
import com.netsuite.suitetalk.proxy.v2019_2.lists.relationships.CustomerSearch;
import com.netsuite.suitetalk.proxy.v2019_2.lists.relationships.CustomerSearchAdvanced;
import com.netsuite.suitetalk.proxy.v2019_2.lists.relationships.CustomerSearchRow;
import com.netsuite.suitetalk.proxy.v2019_2.platform.common.CustomerSearchBasic;
import com.netsuite.suitetalk.proxy.v2019_2.platform.common.CustomerSearchRowBasic;
import com.netsuite.suitetalk.proxy.v2019_2.platform.common.TransactionSearchBasic;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.*;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.types.RecordType;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.types.SearchEnumMultiSelectFieldOperator;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.types.SearchMultiSelectFieldOperator;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.types.SearchStringFieldOperator;
import org.apache.axis.AxisFault;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.netsuite.suitetalk.client.v2019_2.utils.Utils.createRecordRef;
import static com.netsuite.webservices.samples.Messages.*;
import static com.netsuite.webservices.samples.ResponseHandler.processSearchResult;
import static com.netsuite.webservices.samples.utils.PrintUtils.printError;
import static com.netsuite.webservices.samples.utils.PrintUtils.printSendingRequestMessage;

public class NetSuiteSalesOrderSample {
    private static final int DEFAULT_PAGE_SIZE = 1000;
    private static final int PAGE_SIZE = 10;
    private WsClient client;

    private void connect() {
        try {
            client = WsClientFactory.getWsClient(new Properties(), null);
        } catch (MalformedURLException e) {
            printError(INVALID_WS_URL, e.getMessage());
            System.exit(2);
        } catch (AxisFault e) {
            printError(ERROR_OCCURRED, e.getFaultString());
            System.exit(3);
        } catch (IOException e) {
            printError(WRONG_PROPERTIES_FILE, e.getMessage());
            System.exit(1);
        }
    }

    private void searchSalesOrders(String customerName) throws RemoteException {
        List<Customer> customers = searchForCustomers(customerName);
        if (customers.isEmpty()) {
            printError(NO_CUSTOMERS_FOUND, customerName);
            return;
        }

        // Search sales order for all found customers
        SearchMultiSelectField entities = new SearchMultiSelectField();
        entities.setOperator(SearchMultiSelectFieldOperator.anyOf);
        entities.setSearchValue(customers.stream()
                .map(customer -> createRecordRef(customer.getInternalId(), RecordType.customer))
                .toArray(RecordRef[]::new));

        TransactionSearchBasic transactionSearchBasic = new TransactionSearchBasic();
        transactionSearchBasic.setType(new SearchEnumMultiSelectField(
                new String[]{RecordType._salesOrder}, SearchEnumMultiSelectFieldOperator.anyOf));
        transactionSearchBasic.setEntity(entities);

        // We want to returned also list of items so we need to set the following preference
        client.setBodyFieldsOnly(false);

        // Set smaller page size in order to demonstrate how searchMoreWithId() operation works
        client.setPageSize(PAGE_SIZE);

        printSendingRequestMessage();

        // Search for sales orders
        SearchResult searchResult = client.callSearch(transactionSearchBasic);
        final String jobId = client.getLastJobId();

        processSearchResult(searchResult, customerName);

        // Get next pages of the search result
        if (isSuccessfulSearchResult(searchResult)) {
            for (int i = 2; i <= searchResult.getTotalPages(); i++) {
                printSendingRequestMessage();
                processSearchResult(client.callSearchMoreWithId(jobId, i), customerName);
            }
        }

        // We can revert search preferences to the default values now
        client.setBodyFieldsOnly(true);
        client.setPageSize(DEFAULT_PAGE_SIZE);
    }

    /**
     * Search for all customers whose names contains string entered by the user. Since we need just an internal ID
     * of Customer record it is much faster to use advanced search for this particular purpose.
     *
     * @param customerName Customer's name
     */
    private List<Customer> searchForCustomers(String customerName) throws RemoteException {
        // Setting criteria
        SearchStringField entityId = new SearchStringField();
        entityId.setOperator(SearchStringFieldOperator.contains);
        entityId.setSearchValue(customerName);

        CustomerSearchBasic customerSearchBasic = new CustomerSearchBasic();
        customerSearchBasic.setEntityId(entityId);

        CustomerSearch customerSearch = new CustomerSearch();
        customerSearch.setBasic(customerSearchBasic);

        // Setting returned columns
        CustomerSearchRowBasic customerSearchRowBasic = new CustomerSearchRowBasic();
        customerSearchRowBasic.setInternalId(new SearchColumnSelectField[]{new SearchColumnSelectField()});

        CustomerSearchRow customerSearchRow = new CustomerSearchRow();
        customerSearchRow.setBasic(customerSearchRowBasic);

        CustomerSearchAdvanced customerSearchAdvanced = new CustomerSearchAdvanced();
        customerSearchAdvanced.setCriteria(customerSearch);
        customerSearchAdvanced.setColumns(customerSearchRow);

        printSendingRequestMessage();

        List<?> returnedRows = client.searchAll(customerSearchAdvanced);

        if (returnedRows == null || returnedRows.isEmpty()) {
            return Collections.emptyList();
        }

        // Convert returned rows to list of customers
        return returnedRows.stream().map(row -> {
            CustomerSearchRowBasic searchRow = ((CustomerSearchRow) row).getBasic();
            Customer customer = new Customer();
            customer.setInternalId(searchRow.getInternalId(0).getSearchValue().getInternalId());
            return customer;
        }).collect(Collectors.toList());
    }

    private boolean isSuccessfulSearchResult(SearchResult searchResult) {
        return searchResult.getStatus() != null && searchResult.getStatus().isIsSuccess();
    }

    public static void main(String[] args) {
        NetSuiteSalesOrderSample netSuiteSalesOrderSample = new NetSuiteSalesOrderSample();
        netSuiteSalesOrderSample.connect();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter customer name to get sales orders for:");
        String customerName = in.nextLine();
        try {
            netSuiteSalesOrderSample.searchSalesOrders(customerName);
        } catch (RemoteException e) {
            printError(e.getMessage());
        }
    }
}

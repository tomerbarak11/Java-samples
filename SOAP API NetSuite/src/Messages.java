package com.netsuite.webservices.samples;

/**
 * <p>Constants for all messages shown to the user.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public final class Messages {

    public static final String EMPTY_STRING = "";
    public static final String NOT_AVAILABLE = "n/a";
    public static final String SPACE = " ";
    public static final String NON_BREAKING_SPACE = "&nbsp;";
    public static final String INDENTATION_STRING = SPACE;
    public static final String TRUE_SHORT_VALUE = "T";
    public static final String TRUE_LONG_VALUE = "true";
    public static final String YES_SHORT_VALUE = "Y";
    public static final String YES_LONG_VALUE = "yes";
    public static final String LIST_ITEM_DELIMITER = ",";
    public static final String PROMPT = ": ";

    // Log messages prefixes
    public static final String INFO_PREFIX = "[Info]: ";
    public static final String WARNING_PREFIX = "[Warning]: ";
    public static final String ERROR_PREFIX = "[Error]: ";

    // Prompts
    public static final String PROMPT_FOR_LOGIN_INFORMATION = "Please enter your login information:";
    public static final String SELECTION = "Selection";
    public static final char QUIT_CHARACTER = 'Q';
    public static final String QUIT = "Quit";
    public static final String QUIT_CUSTOM_FIELDS = "Quit, no more custom fields to be populated";

    public static final String ADD_CUSTOMER = "Add a Customer";
    public static final String ADD_CUSTOMER_WITH_CUSTOM_FIELDS = "Add a Customer with Custom Fields (CFs must exist)";
    public static final String UPDATE_CUSTOMER = "Update a Customer (Internal ID required)";
    public static final String UPSERT_CUSTOMER = "Upsert a Customer (External ID required)";
    public static final String UPDATE_LIST_OF_CUSTOMERS = "Update a List of Customers (Internal IDs required)";
    public static final String GET_CUSTOMER = "Get a Customer (Internal ID required)";
    public static final String GET_LIST_OF_CUSTOMERS = "Get a List of Customers (Internal IDs required)";
    public static final String DELETE_LIST_OF_CUSTOMERS = "Delete a List of Customers (Internal IDs required)";
    public static final String ADD_INVENTORY_ITEM = "Add an Inventory Item";
    public static final String ADD_SALES_ORDER = "Add a Sales Order";
    public static final String UPDATE_SALES_ORDER = "Update a Sales Order to Add a New Items (Internal ID required)";
    public static final String FULFILL_SALES_ORDER = "Fulfill a Sales Order (Internal ID required)";
    public static final String SEARCH_SALES_ORDERS = "Search Sales Orders by Customer Entity ID";
    public static final String ADVANCED_SEARCH_SALES_ORDERS = "Search Sales Orders with Advanced Search";
    public static final String ADD_CUSTOM_RECORD = "Add a Custom Record (Custom Record type must exist, Internal ID required)";
    public static final String SEARCH_CUSTOM_RECORD = "Search for a Custom Record (Internal ID required)";
    public static final String DELETE_CUSTOM_RECORD = "Delete a Custom Record (Internal ID required)";
    public static final String GET_OTHER_LIST_VALUES = "Get Other List Values";
    public static final String UPLOAD_FILE = "Upload a File";
    public static final String GET_SELECT_FIELD_VALUES = "Get Select Field Values";
    public static final String DELETE_ALL_RECORDS = "Delete all the records above? [y/N]";

    public static final String CUSTOM_FIELDS_WARNING = "In order to populate custom fields, ensure that these fields already exist for the customer record.";
    public static final String CUSTOM_FIELD_STRING = "String (maps to one of Free-Form Text, Text Area, etc. in UI)";
    public static final String CUSTOM_FIELD_VALUE_STRING = "Value (press Enter for default value)";
    public static final String CUSTOM_FIELD_BOOLEAN = "Boolean (maps to Check Box in UI)";
    public static final String CUSTOM_FIELD_VALUE_BOOLEAN = "Value [T/F] (press Enter for True)";
    public static final String CUSTOM_FIELD_LIST = "List (maps to the List/Record type in UI)";
    public static final String CUSTOM_FIELD_VALUE_LIST = "Value for Custom Field (must be an internal ID)";
    public static final String CUSTOM_FIELD_MULTI_SELECT = "Multi-Select List (maps to the Multiple Select type in UI)";
    public static final String CUSTOM_FIELD_VALUE_MULTI_SELECT = "Values for Custom Field (must be internal IDs, separated by commas)";

    public static final String ENTER_LIST_OF_CUSTOMERS = "Enter internal IDs for Customer records to be updated (separated by commas)";
    public static final String INTERNAL_ID_TO_GET = "Internal ID of record to be retrieved";
    public static final String INTERNAL_IDS_TO_GET = "Internal IDs of records to be retrieved (separated by commas)";
    public static final String INTERNAL_IDS_TO_DELETE = "Internal IDs of records to be deleted (separated by commas)";

    public static final String ENTER_ITEM_IDS_FOR_SALES_ORDER = "Please enter the internal IDs of Inventory Items separated by commas (do not enter discount or subtotal items)";
    public static final String ENTER_QUANTITY_FOR_ITEM = "Please enter quantity for item with internal ID %s";

    public static final String ENTER_SALES_ORDER_FOR_UPDATE = "Enter internal ID of Sales Order to be updated";
    public static final String ENTER_SALES_ORDER_FOR_FULFILLING = "Enter internal ID of Sales Order to be fulfilled";
    public static final String ENTER_TRANSACTION_ID = "Enter the transaction ID (press Enter to skip)";
    public static final String ENTER_CUSTOMER_INTERNAL_ID_FOR_SALES_ORDER_SEARCH = "Enter customer internal IDs (separated by commas, press Enter to skip)";

    public static final String ENTER_CUSTOM_RECORD_DATA_FOR_ADD = "Enter the following information for Custom Record to be added:";
    public static final String ENTER_CUSTOM_RECORD_DATA_FOR_SEARCH = "Enter the following information for Custom Record to be searched:";
    public static final String ENTER_CUSTOM_RECORD_DATA_FOR_DELETION = "Enter the following information for Custom Record to be deleted:";

    public static final String BUDGET_CATEGORIES = "Budget Categories";
    public static final String CAMPAIGN_CATEGORIES = "Campaign Categories";
    public static final String STATES = "States";
    public static final String CURRENCIES = "Currencies";

    public static final String FILE_TO_BE_UPLOADED = "File to be uploaded";
    public static final String FILE_NAME = "File name to be used in NetSuite";
    public static final String FOLDER_INTERNAL_ID = "Internal ID of the folder";

    public static final String WRITE_FIELD_NAME = "Write field name of the selected record (press Enter for default value of subsidiary)";

    // Other messages
    public static final String GETTING_URL = "Getting URL using getDataCenterUrls() operation...";
    public static final String SUCCESSFUL_SAVING_CUSTOMER = "The following customer was added/updated successfully:";
    public static final String FAILED_SAVING_CUSTOMER = "The customer was not added/updated: ";
    public static final String SENDING_REQUEST = "Sending request to the server...";
    public static final String PRESS_TO_CONTINUE = "Press Enter to continue...";
    public static final String PRESS_TO_QUIT = "Press Enter to quit...";
    public static final String MAKE_SELECTION = "Please make a selection:";
    public static final String MAKE_CUSTOM_FIELD_SELECTION = "Select the type of custom field to be populated:";
    public static final String ENTER_CUSTOMER_INFORMATION = "Please enter the following customer information.";
    public static final String FIELDS_ALREADY_POPULATED = "Note that some fields have already been populated.";
    public static final String ENTER_CUSTOMER_INFORMATION_FOR_UPDATE = "Please enter the following information for Customer record to be updated:";
    public static final String SUCCESSFULLY_UPDATED_CUSTOMERS = "The following customers were updated successfully:";
    public static final String CUSTOMER = "Customer";
    public static final String CUSTOMER_WITH_INDEX = CUSTOMER + " #%s:";
    public static final String RETRIEVED_RECORD = "Record returned from get() operation:";
    public static final String RETRIEVED_RECORDS = "Records returned from getList() operation:";
    public static final String CHECKING_EXISTENCE_OF_RECORDS = "Checking existence of records with provided internal IDs...";
    public static final String FOLLOWING_RECORDS_WILL_BE_DELETED = "The following records are going to be deleted:";
    public static final String RECORDS_WERE_DELETED = "The following records were deleted (if no error is displayed):";
    public static final String RECORDS_WERE_NOT_DELETED = "The records were not deleted.";
    public static final String ENTER_INFORMATION_FOR_ITEM = "Please enter following information for Inventory Item:";
    public static final String ITEM_SUCCESSFULLY_ADDED = "The item '%s' has been added successfully.";
    public static final String SALES_ORDER_CREATED_OR_UPDATED_SUCCESSFULLY = "Sales order created/updated successfully.";
    public static final String ITEM_FULFILLMENT_RETRIEVED = "Item Fulfillment record was successfully retrieved.";
    public static final String SALES_ORDER_FULFILLED = "Sales order with internal ID %1$s was successfully fulfilled by Item Fulfillment record with internal ID %2$s.";
    public static final String NO_SALES_ORDERS_WITH_CUSTOMER_FOUND = "No sales orders were found for customers with name containing '%s'.";
    public static final String SALES_ORDERS_FOUND = "The following sales orders were found:";
    public static final String SALES_ORDER_WITH_INDEX = "Sales Order #%s:";
    public static final String ITEM_LIST = "Item List:";
    public static final String NO_SEARCH_CRITERIA_DEFINED = "No search criteria were specified. Searching for all records.";
    public static final String NO_SALES_ORDERS_FOUND = "No sales orders were found.";
    public static final String CUSTOM_RECORD_SUCCESSFULLY_ADDED = "The following Custom Record was added:";
    public static final String CUSTOM_RECORDS_FOUND = "The following custom records were found:";
    public static final String NO_CUSTOM_RECORDS_FOUND = "No custom records were found.";
    public static final String CUSTOM_RECORD_WITH_INDEX = "Custom Record #%s:";
    public static final String CUSTOM_RECORD_SUCCESSFULLY_DELETED = "The following Custom Record was deleted:";
    public static final String SELECT_LIST_TYPE = "Select the list type to be retrieved:";
    public static final String NO_RECORDS_FOUND = "No records were found.";
    public static final String REQUESTED_LIST_OF_RECORDS = "The requested list for %s returned %d records:";
    public static final String FILE_UPLOADED = "The file was uploaded successfully:";
    public static final String VENDOR = "Vendor";
    public static final String INVENTORY_ITEM = "Inventory Item";
    public static final String ACCOUNT = "Account";
    public static final String SELECT_RECORD_TYPE_OF_THE_FIELD = "Select the record type containing the select field:";
    public static final String NO_VALUES_FOUND_FOR_THE_FIELD = "No values were found for the field %s.";
    public static final String VALUES_FOUND_FOR_THE_FIELD = "The following %d values were found for the field %s:";

    // Field labels
    public static final String INTERNAL_ID = "Internal ID";
    public static final String EXTERNAL_ID = "External ID";
    public static final String ENTITY_ID = "Entity ID";
    public static final String ENTITY_NAME = "Entity Name (optional depending on your account configuration)";
    public static final String COMPANY_NAME = "Company Name";
    public static final String CUSTOMER_NAME = "Customer Name";
    public static final String EMAIL = "Email";
    public static final String PHONE = "Phone";
    public static final String ENTITY_STATUS = "Status";
    public static final String STATUS_INTERNAL_ID = "Status Internal ID";
    public static final String DEFAULT_STATUS_INTERNAL_ID = "13";
    public static final String ENTITY_STATUS_INTERNAL_ID = "Entity Status Internal ID (press Enter for default value of Closed Won)";
    public static final String ADDRESS_BOOK_LABEL = "Address Book Label";
    public static final String ADDRESS_1 = "Address 1";
    public static final String ADDRESS_2 = "Address 2";
    public static final String ADDRESS_3 = "Address 3";
    public static final String SCRIPT_ID = "Script ID of Custom Field";
    public static final String IS_INACTIVE = "Is Inactive";
    public static final String DATE_CREATED = "Date Created";
    public static final String ITEM_NAME = "Item Name";
    public static final String COSTING_METHOD = "Costing Method (optional - enter 1 for AVERAGE, 2 for FIFO, 3 for LIFO)";
    public static final String BASE_PRICE = "Base Price";
    public static final String BASE_PRICE_WITH_EXAMPLE = BASE_PRICE + ", e.g. 25";
    public static final String QUANTITY = "Quantity";
    public static final String QUANTITY_WITH_EXAMPLE = QUANTITY + ", e.g. 1";
    public static final String TRANSACTION_ID = "Transaction ID";
    public static final String TOTAL_AMOUNT = "Total Amount";
    public static final String CUSTOM_RECORD_TYPE_ID = "Type ID";
    public static final String NAME = "Name";
    public static final String TYPE = "Type";
    public static final String SUBSIDIARY = "subsidiary";
    public static final String TOTAL_RECORDS = "Total Records";
    public static final String TOTAL_PAGES = "Total Pages";
    public static final String PAGE_SIZE = "Page Size";
    public static final String PAGE_INDEX = "Current Page Index";

    // Error messages
    public static final String ERROR = "Error";
    public static final String ERROR_OCCURRED = "An error occurred: %s";
    public static final String WRONG_PROPERTIES_FILE = "Properties file cannot be loaded: %s";
    public static final String INVALID_WS_URL = "Invalid Web Services server URL: %s";
    public static final String INVALID_CHOICE = "Invalid choice. Please select one of the following options.";
    public static final String NO_CUSTOM_FIELDS_SPECIFIED = "There were no custom fields specified. The customer was not added.";
    public static final String NO_VALID_INTERNAL_IDS_FOR_GET_PROVIDED = "There were no valid internal IDs provided thus no records were retrieved.";
    public static final String NO_VALID_INTERNAL_IDS_FOR_UPDATE_PROVIDED = "There were no valid internal IDs provided thus no records were updated.";
    public static final String NO_VALID_INTERNAL_IDS_FOR_DELETE_PROVIDED = "There were no valid internal IDs provided thus no records were deleted.";
    public static final String NO_CUSTOMERS_UPDATED = "None of the customers was updated successfully.";
    public static final String NOT_UPDATED_CUSTOMERS = "The following customers were not updated:";
    public static final String INVALID_NUMBER = "Invalid number entered (%1$s).";
    public static final String ITEM_WITHOUT_PRICING_MATRIX = "Item will be created without pricing matrix.";
    public static final String ITEM_WAS_NOT_ADDED = "The item '%1$s' was not added: %2$s";
    public static final String SALES_ORDER_CUSTOMER_NOT_FOUND = "Sales order was not created because customer with the name '%s' was not found.";
    public static final String SALES_ORDER_MORE_CUSTOMERS_FOUND = "Sales order was not created because more than one customer with name '%s' were found.";
    public static final String ITEM_NOT_ADDED_TO_SALES_ORDER = "This item will not be added to this sales order.";
    public static final String SALES_ORDER_NOT_CREATED_OR_UPDATED = "Sales order was not created/updated: %s";
    public static final String INITIALIZE_OPERATION_FAILED = "Initialize operation failed: %s";
    public static final String SALES_ORDER_NOT_FULFILLED = "Sales order was not fulfilled: %s";
    public static final String NO_CUSTOMERS_FOUND = "No customers with name '%s' were found.";
    public static final String CUSTOM_RECORD_NOT_ADDED = "Custom Record was not added: %s";
    public static final String CUSTOM_RECORD_NOT_DELETED = "Custom Record was not deleted: %s";
    public static final String FILE_NOT_UPLOADED = "The file was not uploaded: %s";
    public static final String SEARCH_FAILED = "Search failed with the following error: %s";
    public static final String EMPTY_WS_URL = "URL is empty. Please fill wsUrl parameter in the [nsclient.properties] file";

    private Messages() {
    }
}

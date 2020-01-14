package com.netsuite.webservices.samples.utils;

import com.netsuite.suitetalk.proxy.v2019_2.platform.core.RecordRef;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.SearchResult;
import com.netsuite.suitetalk.proxy.v2019_2.platform.core.StatusDetail;
import com.netsuite.suitetalk.proxy.v2019_2.platform.messages.ReadResponse;
import com.netsuite.suitetalk.proxy.v2019_2.platform.messages.WriteResponse;

import static com.netsuite.webservices.samples.Messages.NOT_AVAILABLE;

/**
 * <p>Utils class containing some convenient methods for parsing information from SOAP responses.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public final class ParsingUtils {

    private ParsingUtils() {
    }

    public static String getInternalId(WriteResponse response) {
        if (response == null || response.getBaseRef() == null) {
            return NOT_AVAILABLE;
        }
        return ((RecordRef) response.getBaseRef()).getInternalId();
    }

    public static String getErrorMessage(ReadResponse response) {
        if (response == null || response.getStatus() == null) {
            return NOT_AVAILABLE;
        }
        return getErrorMessage(response.getStatus().getStatusDetail());
    }

    public static String getErrorMessage(WriteResponse response) {
        if (response == null || response.getStatus() == null) {
            return NOT_AVAILABLE;
        }
        return getErrorMessage(response.getStatus().getStatusDetail());
    }

    public static String getErrorMessage(SearchResult searchResult) {
        if (searchResult == null || searchResult.getStatus() == null) {
            return NOT_AVAILABLE;
        }
        return getErrorMessage(searchResult.getStatus().getStatusDetail());
    }

    public static String getErrorMessage(StatusDetail[] statusDetails) {
        if (statusDetails == null || statusDetails.length == 0) {
            return NOT_AVAILABLE;
        }
        String errorMessage = statusDetails[0].getMessage();
        return errorMessage == null ? NOT_AVAILABLE : errorMessage;
    }
}

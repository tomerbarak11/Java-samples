package com.netsuite.webservices.samples;

import com.netsuite.suitetalk.client.v2019_2.WsClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * <p>Factory for creating fully initialized web services client.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public final class WsClientFactory {

    private WsClientFactory() {
    }

    public static WsClient getWsClient(Properties properties, URL endpointUrl) throws MalformedURLException, RemoteException {
        WsClient client = new WsClient(endpointUrl == null ? properties.getWebServicesUrl() : endpointUrl);
        if (properties.isTbaRequired()) {
            client.setTokenPassport(properties.getTokenPassport());
        } else {
            client.setRequestLevelCredentials(properties.getPassport());
            client.setApplicationId(properties.getApplicationId());
        }
        return client;
    }
}

package com.netsuite.webservices.samples.utils;

import java.util.Collection;

import static com.netsuite.webservices.samples.Messages.INDENTATION_STRING;

/**
 * <p>Utils class containing some convenient methods for calculating indentation for output strings.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public final class IndentationUtils {

    private static final int INDENTATION = 2;

    private IndentationUtils() {
    }

    public static String getIndentedString(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < INDENTATION; i++) {
            sb.append(INDENTATION_STRING);
        }
        return sb.append(string).toString();
    }

    public static int getNumberPlaces() {
        return INDENTATION + 1;
    }

    public static int getSuitableIndentation(Collection<String> collection) {
        int indentation = 1;
        for (String s : collection) {
            if (s.length() > indentation) {
                indentation = s.length();
            }
        }
        return indentation + INDENTATION;
    }
}

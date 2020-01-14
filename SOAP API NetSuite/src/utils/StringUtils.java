package com.netsuite.webservices.samples.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.netsuite.suitetalk.client.common.utils.CommonUtils.isEmptyString;
import static com.netsuite.webservices.samples.Messages.*;

/**
 * <p>Utils class containing some convenient methods for working with {@code String}s in this sample application.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * This is just a very simple implementation of generating random string
     * but it is sufficient enough for our purposes.
     *
     * @return Random string
     */
    public static String getRandomString() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * @param string String to be converted to string with the first letter capitalized
     * @return String with the first letter capitalized
     */
    public static String getFirstCapitalized(String string) {
        if (isEmptyString(string)) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /**
     * @param list String containing list of items separated by commas
     * @return {@code List} of individual items parsed from given string
     */
    public static List<String> getListItems(String list) {
        return getListItems(LIST_ITEM_DELIMITER, list);
    }

    /**
     * @param listDelimiter Delimiter which separates individual items in provided string
     * @param list          String containing list of items separated by {@code listDelimiter}
     * @return {@code List} of individual items parsed from given string
     */
    public static List<String> getListItems(String listDelimiter, String list) {
        if (isEmptyString(list)) {
            return Collections.emptyList();
        }
        if (isEmptyString(listDelimiter)) {
            return Collections.singletonList(list);
        }
        return Arrays.stream(list.split(listDelimiter))
                .map(String::trim)
                .filter(item -> !item.isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Parser {@code boolean} value from the given string.
     *
     * @param booleanValueAsString String to be parsed
     * @return {@code true} if the string is equal to one of the following options (ignoring case): true, T, yes, Y.
     * {@code false} otherwise.
     */
    public static boolean getBoolean(String booleanValueAsString) {
        return TRUE_SHORT_VALUE.equalsIgnoreCase(booleanValueAsString)
                || TRUE_LONG_VALUE.equalsIgnoreCase(booleanValueAsString)
                || YES_SHORT_VALUE.equalsIgnoreCase(booleanValueAsString)
                || YES_LONG_VALUE.equalsIgnoreCase(booleanValueAsString);
    }
}

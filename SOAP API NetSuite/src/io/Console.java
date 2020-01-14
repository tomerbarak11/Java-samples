package com.netsuite.webservices.samples.io;

import java.util.Scanner;

import static com.netsuite.suitetalk.client.common.utils.CommonUtils.isEmptyString;
import static com.netsuite.webservices.samples.utils.PrintUtils.printPrompt;

/**
 * <p>Console for reading inputs from a user.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public class Console {

    private static java.io.Console systemConsole;
    private static Scanner scanner;

    /*
     * This static block initializes a suitable console.
     * If there is a native console available (e.g. user uses native command line in Windows) then this system
     * console is used. But if the native console is not available (e.g. application is executed from IDE) then
     * some alternative way of reading inputs is used but it does not hide a password entered by the user.
     */
    static {
        systemConsole = System.console();
        if (systemConsole == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static String readLine() {
        if (systemConsole != null) {
            return systemConsole.readLine();
        }
        return readFromScanner();
    }

    public static String readPassword() {
        if (systemConsole != null) {
            return new String(systemConsole.readPassword());
        }
        return readFromScanner();
    }

    public static String readLine(String prompt) {
        printPrompt(prompt);
        return readLine();
    }

    public static String readLine(String prompt, String defaultValue) {
        String readValue = readLine(prompt);
        if (isEmptyString(readValue.trim())) {
            return defaultValue;
        }
        return readValue;
    }

    public static String readPassword(String prompt) {
        printPrompt(prompt);
        return readPassword();
    }

    private static String readFromScanner() {
        if (scanner == null) {
            return null;
        }
        return scanner.nextLine();
    }
}

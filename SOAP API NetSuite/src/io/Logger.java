package com.netsuite.webservices.samples.io;

import static com.netsuite.webservices.samples.Messages.*;

/**
 * <p>This class actually prints messages to the console.</p>
 * <p>© 2019 NetSuite Inc. All rights reserved.</p>
 */
public class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void log(String message) {
        log(message, true);
    }

    private void log(String message, boolean newLine) {
        if (newLine) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
    }

    /**
     * Prints INFO message to the console. The message can be printed with [Info] prefix or without it.
     *
     * @param message        Message to be printed to the console
     * @param showInfoPrefix If {@code true} then also [Info] prefix will be printed before message itself
     */
    public void info(String message, boolean showInfoPrefix) {
        log((showInfoPrefix ? INFO_PREFIX : EMPTY_STRING) + message);
    }

    public void info(String message) {
        log(message);
    }

    public void warning(String message) {
        log(WARNING_PREFIX + message);
    }

    public void error(String message) {
        log(ERROR_PREFIX + message);
    }

    public void prompt(String prompt) {
        log(prompt, false);
    }
}

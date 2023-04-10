package com.report.portal.core.logging;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class Log {
    private static final int CALLED_CLASS_STACK_TRACE_POSITION = 4;

    public static void debug(String message, Object... params) {
        getLogger().debug(String.format(message, params));
    }

    public static void info(String message, Object... params) {
        info(String.format(message, params));
    }

    public static void trace(String message) {
        getLogger().info(message);
    }

    public static void trace(String message, Object... params) {
        getLogger().info(String.format(message, params));
    }

    public static void error(String message, Object... params) {
        error(String.format(message, params));
    }

    @Step("{message}")
    public static void info(String message) {
        getLogger().info(message);
        Reporter.log(message + System.lineSeparator());
    }

    @Step("{message}")
    public static void error(String message) {
        getLogger().error(message);
        Reporter.log(message + System.lineSeparator());
    }

    static Logger getLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[CALLED_CLASS_STACK_TRACE_POSITION].getClassName());
    }
}

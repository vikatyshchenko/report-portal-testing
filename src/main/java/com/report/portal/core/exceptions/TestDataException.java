package com.report.portal.core.exceptions;

import com.report.portal.core.logging.Log;

public class TestDataException extends RuntimeException {

    public TestDataException(final String message) {
        Log.error(message);
        throw new RuntimeException(message);
    }

    public TestDataException(final String messageTemplate, Object... args) {
        Log.error(messageTemplate, args);
        throw new RuntimeException(String.format(messageTemplate, args));
    }

}

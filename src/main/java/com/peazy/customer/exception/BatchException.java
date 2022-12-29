package com.peazy.customer.exception;

public class BatchException extends RuntimeException {

    private static final long serialVersionUID = 7020605923076724518L;

    public BatchException() {
        super();
    }

    public BatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchException(String message) {
        super(message);
    }

    public BatchException(Throwable cause) {
        super(cause);
    }

}

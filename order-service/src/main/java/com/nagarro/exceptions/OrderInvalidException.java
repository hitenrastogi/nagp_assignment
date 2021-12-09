package com.nagarro.exceptions;

public class OrderInvalidException extends RuntimeException {
    public OrderInvalidException() {
    }

    public OrderInvalidException(String message) {
        super(message);
    }

    public OrderInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderInvalidException(Throwable cause) { super(cause); }

}

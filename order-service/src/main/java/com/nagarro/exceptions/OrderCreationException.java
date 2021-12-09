package com.nagarro.exceptions;

public class OrderCreationException extends RuntimeException {
    public OrderCreationException() {
    }

    public OrderCreationException(String message) {
        super(message);
    }

    public OrderCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderCreationException(Throwable cause) {
        super(cause);
    }

}

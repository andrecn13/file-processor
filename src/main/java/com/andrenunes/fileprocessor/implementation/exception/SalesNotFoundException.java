package com.andrenunes.fileprocessor.implementation.exception;

public class SalesNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3979259307206201051L;

    public SalesNotFoundException() {
        super("Sales not found");
    }
}

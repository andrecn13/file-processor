package com.andrenunes.fileprocessor.implementation.exception;

public class InvalidLineFoundException extends RuntimeException {
    private static final long serialVersionUID = -3979259307206201051L;

    public InvalidLineFoundException() {
        super("Could not parse the line");
    }
}

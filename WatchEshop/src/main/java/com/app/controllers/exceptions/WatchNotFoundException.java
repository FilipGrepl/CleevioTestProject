package com.app.controllers.exceptions;

public class WatchNotFoundException extends RuntimeException {
    public WatchNotFoundException(String description) {
        super(description);
    }
}

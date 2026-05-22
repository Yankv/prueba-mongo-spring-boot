package com.yank.pruebaMongoDb.exception;

/**
 * Custom exception class for resource not found errors.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

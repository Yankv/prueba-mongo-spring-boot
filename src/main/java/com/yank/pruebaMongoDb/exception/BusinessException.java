package com.yank.pruebaMongoDb.exception;

/**
 * Custom exception class for business logic errors.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

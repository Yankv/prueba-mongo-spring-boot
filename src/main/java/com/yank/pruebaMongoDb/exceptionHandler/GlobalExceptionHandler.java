package com.yank.pruebaMongoDb.exceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yank.pruebaMongoDb.exception.BusinessException;
import com.yank.pruebaMongoDb.exception.ResourceNotFoundException;

/**
 * Global exception handler for the application.
 * This class handles various exceptions that may occur during request
 * processing and returns appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handle not found exceptions, such as when a requested resource does not exist
    // Response with 404 Not Found and a message indicating the resource was not
    // found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(ResourceNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Handle business logic exceptions, such as when a request violates business
    // rules (e.g., duplicate email)
    // Response with 400 Bad Request and a message indicating the business rule
    // violation
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    // Handle validation exceptions, such as @Valid errors in request bodies
    // Response with 400 Bad Request and a list of validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Validation error");
        body.put("errors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Handle any other exceptions that are not specifically handled by the above
    // methods
    // Response with 500 Internal Server Error and a generic message
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }
}

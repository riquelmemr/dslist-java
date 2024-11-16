package com.appgame.dslist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> handleGenericException(Exception ex) {
        AppError error = new AppError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error", ex.getMessage() );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<AppError> handleEntityNotFound(EntityNotFoundException ex) {
        AppError error = new AppError(HttpStatus.NOT_FOUND, ex.getMessage(), "Entity not found.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

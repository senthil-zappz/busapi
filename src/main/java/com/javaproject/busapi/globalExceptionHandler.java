package com.javaproject.busapi;

import com.javaproject.busapi.errorResponse;
import com.javaproject.busapi.Exceptions.busRouteNotFoundException;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(globalExceptionHandler.class);

    @ExceptionHandler(busRouteNotFoundException.class)
    public ResponseEntity<errorResponse> handleBusRouteNotFoundException(busRouteNotFoundException ex) {
        errorResponse errorResponse = new errorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // GENERAL EXCEPTION HANDLER
    @ExceptionHandler(Exception.class)
    public ResponseEntity<errorResponse> handleException(Exception ex) {
        // Add logging here
        logger.error(ex.getMessage());
        // Return a generic error response so as not to leak sensitive information
        errorResponse errorResponse = new errorResponse("Something went wrong", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.msb.firstjobapp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> noResourceFoundExceptionHandler(NoResourceFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse("NOT FOUND", e.toString()), HttpStatus.NOT_FOUND);
    }
}

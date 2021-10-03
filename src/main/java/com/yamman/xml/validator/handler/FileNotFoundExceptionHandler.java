package com.yamman.xml.validator.handler;

import com.yamman.xml.validator.exception.RestApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class FileNotFoundExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<RestApiError> handle(FileNotFoundException ex) {
        return new ResponseEntity<>(new RestApiError(ex.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

}

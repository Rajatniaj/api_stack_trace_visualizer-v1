package com.tgt.api.controller;

import com.tgt.api.util.Constants;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

/**
 * Created by z001t7s on 2/26/17.
 */
@ControllerAdvice
@Slf4j
public class StackTraceVisualizerExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(StackTraceVisualizerExceptionHandler.class);


    @ExceptionHandler( {NotFoundException.class} )
    public ResponseEntity<String> handleResourceNotFound(Exception ex) {

        return new ResponseEntity<String>("Requested User or application not found in database ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequests(Exception ex) {

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

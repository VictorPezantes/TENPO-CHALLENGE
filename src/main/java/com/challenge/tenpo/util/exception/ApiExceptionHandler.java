/*
 * @(#)ApiExceptionHandler.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
/**
 * ApiExceptionHandler.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends Throwable {

    // -------------------------------------------------------------------
    // --Private Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * handleNotFoundException
     * return the exception NOT FOUND.
     *
     * @param ex {@link Exception}
     * @return ResponseEntity de {@link ErrorResponse}
     */

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    /**
     * handleBadRequestException
     * return the exception BAD REQUEST.
     *
     * @param ex {@link Exception}
     * @return ResponseEntity de {@link ErrorResponse}
     */
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            ConflictException.class,
            ConstraintViolationException.class
    })

    /**
     * handleConflictException
     * return the exception CONFLICT.
     *
     * @param ex {@link Exception}
     * @return ResponseEntity de {@link ErrorResponse}
     */
    public ResponseEntity<ErrorResponse> handleConflictException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // -------------------------------------------------------------------
    // -- Private Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * getErrorResponse
     *
     * @param ex,httpStatus {@link Exception,HttpStatus}
     * @return ErrorResponse de {@link ErrorResponse}
     */

    private ErrorResponse getErrorResponse(Exception ex, HttpStatus httpStatus) {
        String causeMessage = ex.getMessage();
        int httpCode = httpStatus.value();
        String httpName = httpStatus.name();
        String clazz = getClassName(ex);
        String method = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getMethodName() : "Not found";
        int line = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getLineNumber() : 0;

        return ErrorResponse.builder()
                .clazz(clazz)
                .httpStatus(httpCode)
                .message(causeMessage)
                .method(method)
                .type(httpName)
                .line(line)
                .build();
    }

    // -------------------------------------------------------------------
    // -- Private  Class -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * getClassName
     *
     * @param ex {@link Exception}
     * @return String de {@link String}
     */


    private String getClassName(Exception ex) {
        String className = "Not found";

        try {
            className = Class.forName(ex.getStackTrace()[0].getClassName()).getName();

        } catch (Exception ignored) {

        }

        return className;
    }

}

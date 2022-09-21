/*
 * @(#)ConflictException.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.util.exception;
/**
 * ConflictException.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
public class ConflictException extends RuntimeException{
    // -------------------------------------------------------------------
    // -- Constructor Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * Use the response inherit of RuntimeException
     *
     * @param detail {@link String}
     * @return {@link ConflictException}
     */
    public ConflictException(String detail){
        super(detail);
    }
}

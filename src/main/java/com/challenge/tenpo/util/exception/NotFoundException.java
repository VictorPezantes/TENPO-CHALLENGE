/*
 * @(#)NotFoundException.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.util.exception;
/**
 * NotFoundException.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
public class NotFoundException extends RuntimeException{
    // -------------------------------------------------------------------
    // -- Constructor Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * Use the response inherit of RuntimeException
     *
     * @param detail {@link String}
     * @return {@link NotFoundException}
     */
    public NotFoundException(String detail){
        super(detail);
    }
}

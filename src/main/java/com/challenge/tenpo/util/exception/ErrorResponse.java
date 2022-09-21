/*
 * @(#)ErrorResponse.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.util.exception;

import lombok.Builder;
import lombok.Getter;
/**
 * ErrorResponse.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Getter
@Builder
public class ErrorResponse {

    private int httpStatus;
    private String type, message, clazz, method;
    private int line;
}

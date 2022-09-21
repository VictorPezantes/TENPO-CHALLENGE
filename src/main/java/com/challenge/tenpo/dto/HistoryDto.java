/*
 * @(#)HistoryDto.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.dto;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HistoryDto.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {
    @JMap
    private int id;
    @JMap
    private String uri;
    @JMap
    private String method;
    @JMap
    private String userRemote;
    @JMap
    private String host;
    @JMap
    private String country;
    @JMap
    private double ultimoValorRetornado;
    @JMap
    private String dateConsult;
}

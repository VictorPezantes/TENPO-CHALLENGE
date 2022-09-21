/*
 * @(#)HistoryService.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.service;


import com.challenge.tenpo.dto.HistoryDto;


import java.util.List;
/**
 * HistoryService.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
public interface HistoryService {

    // -------------------------------------------------------------------
    // -- Define Methods -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * get history list from callback services
     *
     * @return {@link HistoryDto}
     */

List<HistoryDto> listHistory();
    /**
     * calculate the operation when the rest client fail
     *
     * @return {@link Double}
     */
double calculateFallback();
    /**
     * save the history from callbacks services
     *
     * @return {@link Double}
     */
void saveHistory();

}

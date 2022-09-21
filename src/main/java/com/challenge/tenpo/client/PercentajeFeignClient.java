/*
 * @(#)PercentajeFeignClient.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.client;


import com.challenge.tenpo.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * PercentajeFeignClient.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@FeignClient(name = "PERCENTAGE-API", url = "${external.api.base.url}",configuration = FeignClientConfig.class)
public interface PercentajeFeignClient {

        // -------------------------------------------------------------------
        // -- Define Methods -----------------------------------------------
        // -------------------------------------------------------------------
        /**
         * Define method that get data from rest client
         *
         * @return {@link Double}
         */
        @GetMapping(value = "/api/random", consumes = MediaType.APPLICATION_JSON_VALUE)
        public double getNumberRandom();

}

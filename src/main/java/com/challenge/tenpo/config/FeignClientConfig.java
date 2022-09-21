/*
 * @(#)FeignClientConfig.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignClientConfig.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@Configuration
public class FeignClientConfig {

    // -------------------------------------------------------------------
    // -- Define Beans -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Define Bean tha return a level error
     *
     * @return {@link Double}
     */

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

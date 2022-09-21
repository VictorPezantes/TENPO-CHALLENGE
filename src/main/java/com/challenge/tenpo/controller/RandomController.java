/*
 * @(#)RandomController.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * RandomController.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class RandomController {



    // -------------------------------------------------------------------
    // -- Public Methods -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * signin user to login app
     *
     *
     * @return {@link ResponseEntity}
     */

    @GetMapping("/random")
    @ApiOperation("calculate random number")
    public ResponseEntity<?> getNumberRandom() {

        Random random = new Random();
        int numRandom = random.nextInt(100);
        return new ResponseEntity(numRandom, HttpStatus.OK);
    }


}


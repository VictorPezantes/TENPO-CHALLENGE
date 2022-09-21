/*
 * @(#)CalculateController.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.controller;

import com.challenge.tenpo.dto.HistoryDto;
import com.challenge.tenpo.service.impl.HistoryServiceImpl;
import com.challenge.tenpo.util.exception.ApiExceptionHandler;
import com.challenge.tenpo.util.pagination.PaginationUtils;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * CalculateController.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Slf4j
public class CalculateController {

    @Autowired
    HistoryServiceImpl historyService;

    // -------------------------------------------------------------------
    // -- Public Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * calculate the percentage
     *
     * @param num1,num2 {@link Integer}
     * @return {@link ResponseEntity}
     */

    @GetMapping("/percentage")
    @CircuitBreaker(name = "calculateService",fallbackMethod = "CalculateByPercentageRandom")
    public ResponseEntity<?> calculatePercentage(@RequestParam("num1") int num1,
                                                 @RequestParam("num2") int num2) throws ApiExceptionHandler {
        double result=0;
        try {
            log.info("consult method that calculate the operation");
            result = historyService.calculate(num1, num2);
            log.info("response consult method calculate is ok");
            log.info("save history callback services ok");
            historyService.saveHistory();
        } catch (Exception e) {
            log.info("response consult method calculate is  no ok");
            throw  new ApiExceptionHandler();
        }
        return new ResponseEntity(result, HttpStatus.OK);

    }

    /**
     * get history from services
     *
     * @param page,size,model {@link Integer,Model}
     * @return {@link String}
     */

    @GetMapping(value = "/history", produces = "application/json")
    public String getHistoryServices(@RequestParam(value = "numpage") Integer page,
                                     @RequestParam(value = "size") Integer size,
                                     Model model) throws ApiExceptionHandler {

        List<HistoryDto> listHistory = null;

        try {
            log.info(" start of consult method that get call the services ");
            listHistory = historyService.listHistory();
        } catch (Exception e) {
            log.info("response consult method calculate is  no ok");
            throw  new ApiExceptionHandler();
        }
        return PaginationUtils.getPaginationedResults(listHistory,page,size,model);
    }

    /**
     * Method Fallback to implent circuitbreak. calculate the su with the las number saved
     *
     * @param n1,n2 {@link Integer}
     * @return {@link ResponseEntity}
     */

    public ResponseEntity<?> CalculateByPercentageRandom(@RequestParam("n1") int n1,
                                                 @RequestParam("n2") int n2,RuntimeException e) {

            log.info("consult method that response a  operation with a random number");
          double  result = historyService.calculateFallback();

        return new ResponseEntity(result, HttpStatus.OK);

    }

}

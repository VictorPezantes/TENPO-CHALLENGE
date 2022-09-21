/*
 * @(#)HistorialServiceImpl.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.service.impl;


import com.challenge.tenpo.client.PercentajeFeignClient;

import com.challenge.tenpo.dto.HistoryDto;
import com.challenge.tenpo.entity.HistoryEntity;
import com.challenge.tenpo.repository.HistoryRepository;
import com.challenge.tenpo.service.HistoryService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * HistorialServiceImpl.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@Service
@Slf4j
public class HistoryServiceImpl implements HistoryService {

    @Autowired
     PercentajeFeignClient percentajeFeignClient;
    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    HistoryRepository historyRepository;

    // -------------------------------------------------------------------
    // -- Public Methods -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * calculate the operation with percentage from rest client
     *
     * @param num1,num2 {@link Integer}
     * @return {@link Double}
     */

    public double calculate(int num1, int num2){

        double sumatotal=0;
        double numberRandom = getPercentageRandom();

        if(numberRandom==0.0){
            double valorPorDefecto = historyRepository.findLastValueReturned();
            sumatotal= numberRandom+num1+num2;
            return sumatotal;
        }else {
            sumatotal= num1 +num2 +numberRandom;
        }
        return sumatotal;
    }

    /**
     * get percentage random from rest client, implementation of Scheduler to call the service every 30 minutes
     *
     * @return {@link Double}
     */
    @Scheduled(cron = "*/10 * * * * *")
    public double getPercentageRandom(){

        double porcentaje=0;
        double  numberRandom=0;

        try {
            numberRandom =percentajeFeignClient.getNumberRandom();
            porcentaje= numberRandom /100;
            log.info("getting the percentage fron random number : "+  porcentaje+"%");
            return porcentaje;

        }catch (FeignException e) {
            log.info("error to call the  rest client: "+ e.getMessage());
        }

        return porcentaje;
    }

    // -------------------------------------------------------------------
    // -- Override Methods -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * return list of History form calbbacks services
     *
     * @return {@link HistoryDto}
     */
@Override
    public List<HistoryDto> listHistory() {
    log.info("find all history data from callbacks services ");
        return  historyRepository.findAll().stream().map(HistoryEntity::toHistoryDto).collect(Collectors.toList());

    }

    /**
     * calculate the operation when the rest client fail
     *
     * @return {@link Double}
     */
    @Override
    public double calculateFallback() {
        log.info("find the last number save from client service ");
        double ultimoValorRetornado = historyRepository.findLastValueReturned();
        return ultimoValorRetornado;
    }

    /**
     * save the history from callbacks services
     *
     * @return {@link Double}
     */
    @Override
    public void saveHistory() {

        log.info("call the client service to return de random number");
        double numberRandom = getPercentageRandom();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);
        String urlServicioRequest =httpServletRequest.getRequestURI();
        String method =httpServletRequest.getMethod();
        String remoteUser =httpServletRequest.getRemoteUser();
        String remoteHost =httpServletRequest.getRemoteHost();
        String country =httpServletRequest.getLocale().getCountry();
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setCountry(country);
        historyEntity.setUri(urlServicioRequest);
        historyEntity.setHost(remoteHost);
        historyEntity.setMethod(method);
        historyEntity.setUserRemote(remoteUser);
        historyEntity.setUltimoValorRetornado(numberRandom);
        historyEntity.setDateConsult(formattedDateTime);
        log.info("save data form callback services");
        historyRepository.save(historyEntity);

    }


}

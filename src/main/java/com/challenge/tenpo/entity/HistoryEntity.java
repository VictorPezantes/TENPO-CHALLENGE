/*
 * @(#)HistoryEntity.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.entity;

import com.challenge.tenpo.dto.HistoryDto;
import com.googlecode.jmapper.JMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * HistoryEntity.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@Entity(name="historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uri;
    private String method;
    private String userRemote;
    private String host;
    private String country;
    private double ultimoValorRetornado;
    private String dateConsult;

    public HistoryDto toHistoryDto() throws ClassCastException {
        return new JMapper<>(HistoryDto.class, HistoryEntity.class)
                .getDestination(this);
    }
}

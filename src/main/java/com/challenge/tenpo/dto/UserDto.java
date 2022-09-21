/*
 * @(#)UserDto.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.dto;


import com.challenge.tenpo.entity.RolEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

/**
 * UserDto.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String name;
    private String userName;
    private String email;
    private Set<RolEntity> roles = new HashSet<>();
}

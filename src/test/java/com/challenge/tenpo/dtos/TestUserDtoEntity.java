/*
 * @(#)UserController.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.dtos;

import com.challenge.tenpo.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * testGettersAndSetters.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */


public class TestUserDtoEntity {

    // -------------------------------------------------------------------
    // -- Tests ----------------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Test.
     */

    @Test
    void testGettersAndSetters() {
        final var rq = UserDto.builder()
                .id(0)
                .name("")
                .userName("")
                .email("")
                .build();
        Assertions.assertNotNull(rq.getId());
        Assertions.assertNotNull(rq.getUserName());
        Assertions.assertNotNull(rq.getName());
        Assertions.assertNotNull(rq.getEmail());

    }

}

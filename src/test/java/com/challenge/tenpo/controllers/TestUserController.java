/*
 * @(#)UserController.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.controllers;


import com.challenge.tenpo.service.UserService;
import com.challenge.tenpo.util.exception.ConflictException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


/**
 * TestUserController.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@ExtendWith(MockitoExtension.class)
public class TestUserController {
    /** service. */
    @Mock
    UserService userService;
    /** instance. */


    // -------------------------------------------------------------------
    // -- Tests ----------------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Test to mock the create a new user
     *
     * @throws ConflictException {@link ConflictException}
     */
    @Test
    void testCreateUser() throws ConflictException {

    }

}

/*
 * @(#)AuthController.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.controller;

import com.challenge.tenpo.dto.JwtDto;
import com.challenge.tenpo.dto.SignInUserDto;
import com.challenge.tenpo.dto.Message;
import com.challenge.tenpo.dto.SignUpUserDto;
import com.challenge.tenpo.service.UserService;
import com.challenge.tenpo.security.jwt.JwtProvider;
import com.challenge.tenpo.util.exception.ApiExceptionHandler;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.ParseException;

/**
 * AuthController.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
@Slf4j
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    // -------------------------------------------------------------------
    // -- Public Methods -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * signin user to login app
     *
     * @param signUpUserDto {@link SignUpUserDto}
     * @return {@link ResponseEntity}
     */

    @PostMapping("/signup")
    @ApiOperation("signup user to login app")
    public ResponseEntity<?> signin(@Valid @RequestBody SignUpUserDto signUpUserDto,
                                    BindingResult bindingResult) throws ApiExceptionHandler {
        try {
            log.info("validate data from request");
            if (bindingResult.hasErrors())
                return new ResponseEntity(new Message("wrong fields or invalid email"), HttpStatus.BAD_REQUEST);
            if (userService.existsByUserName(signUpUserDto.getUserName()))
                return new ResponseEntity(new Message("that name already exists"), HttpStatus.BAD_REQUEST);
            if (userService.existsByEmail(signUpUserDto.getEmail()))
                return new ResponseEntity(new Message("that email already exists"), HttpStatus.BAD_REQUEST);
            log.info("save new user into data base");
            userService.save(signUpUserDto);
        }catch (Exception e) {
            log.info("response signup is  no ok");
            throw  new ApiExceptionHandler();
        }

        return new ResponseEntity(new Message("user save ok"), HttpStatus.CREATED);
    }

    /**
     * SignUp new user
     *
     * @param loginUsuario {@link SignInUserDto}
     * @return {@link ResponseEntity}
     */

    @PostMapping("/signin")
    @ApiOperation("signin user to login app")
    public ResponseEntity<JwtDto> signup(@Valid @RequestBody SignInUserDto loginUsuario,
                                         BindingResult bindingResult) throws ApiExceptionHandler {
        JwtDto jwtDto;
        try {
            log.info("validate data from request");
            if (bindingResult.hasErrors())
                return new ResponseEntity(new Message("misplaced fields"), HttpStatus.BAD_REQUEST);
            log.info("validate authentication user");
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginUsuario.getUserName(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        }catch (Exception e) {
            log.info("response signin is  no ok");
            throw  new ApiExceptionHandler();
        }

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    /**
     * refresh jwt
     * @param jwtDto {@link JwtDto}
     * @return {@link ResponseEntity}
     */

    @PostMapping("/refresh")
    @ApiOperation(" refresh the jwt")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        log.info("refresh jwt defeated");
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }

}


/*
 * @(#)HistoryEntity.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.tenpo.dto.SignUpUserDto;
import org.slf4j.Logger;
import org.slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
/**
 * HistoryEntity.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{


	
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	// -------------------------------------------------------------------
	// -- Override Methods -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * verify if  user is authenticated
	 *
	 * @param request,response,authException {@link HttpServletRequest,HttpServletResponse,AuthenticationException}
	 * @return {@link HttpServletResponse}
	 */

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		logger.error("fail en el method commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, " user is unauthorized");
		
		
	}

}

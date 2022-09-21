/*
 * @(#)UsuarioService.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * UsuarioService.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ChallengeTenpoApplication {

	// -------------------------------------------------------------------
	// -- Public Methods -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * Main routine -- It starts the application context.
	 *
	 * @param args {@link String}
	 */

	public static void main(String[] args) {
		SpringApplication.run(ChallengeTenpoApplication.class, args);
	}

}

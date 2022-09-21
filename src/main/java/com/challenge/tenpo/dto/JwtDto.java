/*
 * @(#)JwtDto.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * JwtDto.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {

	private String token;
	private String userName;
	private Collection<? extends  GrantedAuthority> authorities;

	public JwtDto(String token) {
		this.token = token;
	}

}

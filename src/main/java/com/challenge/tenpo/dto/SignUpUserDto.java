/*
 * @(#)SignUpUserDto.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
/**
 * SignUpUserDto.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Data
@NoArgsConstructor
public class SignUpUserDto {
	
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String userName;

	private Set<String> roles = new HashSet<>();

	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	

}

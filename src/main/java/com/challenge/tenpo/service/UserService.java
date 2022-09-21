/*
 * @(#)UsuarioService.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import com.challenge.tenpo.entity.UserEntity;
import com.challenge.tenpo.util.enums.RolName;
import com.challenge.tenpo.dto.SignUpUserDto;
import com.challenge.tenpo.entity.RolEntity;
import com.challenge.tenpo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * UsuarioService.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RolService rolService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// -------------------------------------------------------------------
	// -- Public Methods -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * get user by user name
	 *
	 * @param userName {@link String}
	 * @return {@link UserEntity}
	 */

	public Optional<UserEntity> getByNombreUsuario(String userName) {
		return userRepository.findByUserName(userName);

	}
	/**
	 * get user by user name or email
	 *
	 * @param nombreOrEmail {@link String}
	 * @return {@link UserEntity}
	 */
	public Optional<UserEntity> getByUserNameOrEmail(String nombreOrEmail) {
		return userRepository.findByUserNameOrEmail(nombreOrEmail, nombreOrEmail);

	}
	/**
	 * search if exists user by user name
	 *
	 * @param nombreUsuario {@link String}
	 * @return {@link Boolean}
	 */
	public boolean existsByUserName(String nombreUsuario) {

		return userRepository.existsByUserName(nombreUsuario);
	}

	/**
	 * search if exists user by email
	 *
	 * @param email {@link String}
	 * @return {@link Boolean}
	 */

	public boolean existsByEmail(String email) {

		return userRepository.existsByEmail(email);
	}

	/**
	 * save new user
	 *
	 * @param signUpUserDto {@link String}
	 */
	public void save(SignUpUserDto signUpUserDto) {

		UserEntity user = new UserEntity(signUpUserDto.getName(), signUpUserDto.getUserName(),
				signUpUserDto.getEmail(), passwordEncoder.encode(signUpUserDto.getPassword()));

		Set<RolEntity> roles = new HashSet<>();
		roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
		if (signUpUserDto.getRoles().contains("admin")) roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
		user.setRoles(roles);
		userRepository.save(user);
	}
	



}

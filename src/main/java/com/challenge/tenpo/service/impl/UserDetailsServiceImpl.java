/*
 * @(#)UserDetailsServiceImpl.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.service.impl;


import com.challenge.tenpo.entity.UserEntity;
import com.challenge.tenpo.entity.UserMain;
import com.challenge.tenpo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



/**
 * UserDetailsServiceImpl.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 10-09-2022
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	// -------------------------------------------------------------------
	// -- Override Methods -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * return data about user seraching with username or email
	 *
	 * @param nameOrEmail {@link String}
	 * @return {@link UserDetails}
	 */
	@Override
	public UserDetails loadUserByUsername(String nameOrEmail) throws UsernameNotFoundException {

		UserEntity user = userService.getByUserNameOrEmail(nameOrEmail).get();
		return UserMain.build(user);
	}

}

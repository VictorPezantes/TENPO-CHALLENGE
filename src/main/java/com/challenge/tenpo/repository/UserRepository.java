/*
 * @(#)UserRepository.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.repository;


import com.challenge.tenpo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * UserRepository.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	// -------------------------------------------------------------------
	// -- Define Methods Customizables -----------------------------------------------
	// -------------------------------------------------------------------

	/**
	 *
	 * get user by name user
	 *
	 * @param userName {@link String}
	 * @return Optional de {@link UserEntity}
	 */
	Optional<UserEntity> findByUserName(String userName);
	/**
	 *
	 * get user by name user or email
	 *
	 * @param userName,email {@link String}
	 * @return Optional de {@link UserEntity}
	 */
	Optional<UserEntity>findByUserNameOrEmail(String userName, String email);
	/**
	 *
	 * search if name user exists
	 *
	 * @param userName {@link String}
	 *  @return {@link Boolean}
	 */

	boolean existsByUserName(String userName);
	/**
	 *
	 * search if email user exists
	 *
	 * @param email {@link String}
	 *  @return {@link Boolean}
	 */
	boolean existsByEmail(String email);


	
	

}

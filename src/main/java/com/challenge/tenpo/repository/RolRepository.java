/*
 * @(#)RolRepository.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.repository;

import java.util.Optional;

import com.challenge.tenpo.util.enums.RolName;
import com.challenge.tenpo.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * RolRepository.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer>{

	// -------------------------------------------------------------------
	// -- Define Methods Customizables -----------------------------------------------
	// -------------------------------------------------------------------

	/**
	 *
	 * get name rol
	 *
	 * @param rolName {@link RolName}
	 * @return Optional de {@link RolEntity}
	 */
	
	Optional<RolEntity>findByRolName(RolName rolName);

}

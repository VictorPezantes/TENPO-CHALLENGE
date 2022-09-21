/*
 * @(#)RolService.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.service;

import java.util.Optional;


import com.challenge.tenpo.repository.RolRepository;
import com.challenge.tenpo.util.enums.RolName;
import com.challenge.tenpo.entity.RolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * RolService.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Service
@Transactional
public class RolService {
	
	@Autowired
	RolRepository rolRepository;

	// -------------------------------------------------------------------
	// -- Public Methods -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * get rol by rol name
	 *
	 * @param rolName {@link RolName}
	 * @return {@link RolEntity}
	 */
	
	public Optional<RolEntity> getByRolName(RolName rolName){
		
		return rolRepository.findByRolName(rolName);
	}
	/**
	 * save rol
	 *
	 * @param rol {@link RolEntity}
	 */
	public void save(RolEntity rol) {
		rolRepository.save(rol);
	}
	
	

}

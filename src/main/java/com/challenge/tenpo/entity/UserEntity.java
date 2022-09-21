/*
 * @(#)UserEntity.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */

package com.challenge.tenpo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
/**
 * UserEntity.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Entity(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	@Column(unique = true)
	private String userName;
	@NotNull
	private String email;
	@NotNull
	private String password;
	private String tokenPassword;

	// -------------------------------------------------------------------
	// -- Entity Relation -----------------------------------------------
	// -------------------------------------------------------------------
	/**
	 * define the relation between entities usuario_rol and rol
	 *
	 */
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<RolEntity> roles = new HashSet<>();

	public UserEntity(@NotNull String name, @NotNull String userName, @NotNull String email,
					  @NotNull String password) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

}

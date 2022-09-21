/*
 * @(#)UserMain.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * UserMain.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMain implements UserDetails {

    private String name;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public static UserMain build(UserEntity usuario) {

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());

        return new UserMain(usuario.getName(), usuario.getUserName(), usuario.getEmail(),
                usuario.getPassword(), authorities);

    }

    // -------------------------------------------------------------------
    // -- Override Methods -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     * get Authorities from  user_rol
     *
     * @return {@link Collection}
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return userName;
    }

    /**
     * return true if account in not expired
     *
     * @return {@link boolean}
     */
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }


    /**
     * return true if account in not locked
     *
     * @return {@link boolean}
     */
    @Override
    public boolean isAccountNonLocked() {

        return true;
    }


    /**
     * return true if credentials in not expired
     *
     * @return {@link boolean}
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    /**
     * return true if account is enabled
     *
     * @return {@link boolean}
     */
    @Override
    public boolean isEnabled() {

        return true;
    }


}

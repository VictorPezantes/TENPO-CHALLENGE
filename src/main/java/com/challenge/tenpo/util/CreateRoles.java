package com.challenge.tenpo.util;


import com.challenge.tenpo.entity.RolEntity;
import com.challenge.tenpo.service.RolService;
import com.challenge.tenpo.util.enums.RolName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {

		 /*RolEntity rolAdmin = new RolEntity(RolName.ROLE_ADMIN);
          RolEntity rolUser = new RolEntity(RolName.ROLE_USER);
          rolService.save(rolAdmin);
		  rolService.save(rolUser);*/


    }
}

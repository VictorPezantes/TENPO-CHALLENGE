/*
 * @(#)RolRepository.java
 *
 * Copyright (c) VICTOR RODRIGUEZ (Chile). All rights reserved.
 *
 * All rights to this product are owned by VICTOR RODRIGUEZ
 */
package com.challenge.tenpo.repository;

import com.challenge.tenpo.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * RolRepository.
 *
 * @author Víctor Rodríguez.
 * @version 1.0.0, 06-09-2022
 */
@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity,Long> {
// -------------------------------------------------------------------
    // -- Define Methods Customizables -----------------------------------------------
    // -------------------------------------------------------------------

    /**
     *
     * find the last value save from rest client
     *
     * @return double de {@link Double}
     */
    @Query(value = " select ultimo_valor_retornado from historial where id=(select MAX(id) from historial)", nativeQuery = true)
    double findLastValueReturned();

}
package com.unicauca.maestria.computacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.maestria.computacion.domain.TipoTramite;

@Repository
public interface TipoTramiteRepository extends JpaRepository<TipoTramite, Integer> {
    
}

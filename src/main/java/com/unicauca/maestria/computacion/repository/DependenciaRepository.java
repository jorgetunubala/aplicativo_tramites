package com.unicauca.maestria.computacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.maestria.computacion.domain.Dependencia;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia,Integer> {
    
}

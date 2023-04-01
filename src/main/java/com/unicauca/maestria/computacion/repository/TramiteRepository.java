package com.unicauca.maestria.computacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unicauca.maestria.computacion.domain.Tramite;

@Repository
public interface TramiteRepository extends JpaRepository<Tramite, Integer> {
    
    @Query("SELECT COUNT(t) " +
        " FROM Tramite t " +
        " where t.activo = 1 ")
    Integer getTotalTramitesActivos();

    @Query("Select t " +
        " FROM Tramite t " +
        " JOIN FETCH t.tipoTramite tt " +
        " JOIN FETCH t.tipoRecepcion tr " +
        " where t.activo = 1 ")
    List<Tramite> getTramites();

}

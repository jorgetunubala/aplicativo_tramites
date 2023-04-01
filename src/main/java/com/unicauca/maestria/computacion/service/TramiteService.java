package com.unicauca.maestria.computacion.service;

import java.util.List;

import com.unicauca.maestria.computacion.domain.Tramite;
import com.unicauca.maestria.computacion.dto.TramiteDTO;
import com.unicauca.maestria.computacion.dto.TramiteSaveDTO;

public interface TramiteService {
    
    Integer getConteoTramitesActivos() throws Exception;

    List<TramiteDTO> getTramites() throws Exception;

    TramiteDTO guardarTramite(TramiteSaveDTO tramiteSaveDTO) throws Exception;
}

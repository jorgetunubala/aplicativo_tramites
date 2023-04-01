package com.unicauca.maestria.computacion.service.impl;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.maestria.computacion.domain.Dependencia;
import com.unicauca.maestria.computacion.domain.TipoTramite;
import com.unicauca.maestria.computacion.domain.Tramite;
import com.unicauca.maestria.computacion.dto.TipoTramiteDTO;
import com.unicauca.maestria.computacion.dto.TramiteDTO;
import com.unicauca.maestria.computacion.dto.TramiteSaveDTO;
import com.unicauca.maestria.computacion.repository.DependenciaRepository;
import com.unicauca.maestria.computacion.repository.TipoTramiteRepository;
import com.unicauca.maestria.computacion.repository.TramiteRepository;
import com.unicauca.maestria.computacion.service.TramiteService;

@Service
public class TramiteServiceImpl implements TramiteService{

    @Autowired
    private TramiteRepository tramiteRepository;
    @Autowired
    private TipoTramiteRepository tipoTramiteRepository;
    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Override
    public Integer getConteoTramitesActivos() throws Exception {
        Integer totalActivos;
        try{
            totalActivos = tramiteRepository.getTotalTramitesActivos();            
        } catch (Exception e) {
            throw new Exception("Error inesperado consultanto el total de tramites activos. " + e.getMessage());
        }        
        return totalActivos;
    }

    @Override
    public List<TramiteDTO> getTramites() throws Exception {
        List<TramiteDTO> tramites = new ArrayList<>();
        try {
            List<Tramite> tramitesList = tramiteRepository.getTramites();
            for (Tramite t : tramitesList) {
                tramites.add(convertTramiteToTramiteDTO(t));
            }
        } catch (Exception e) {
            throw new Exception("Error inesperado consultanto la lista de tramites activos. " + e.getMessage());
        }
        return tramites;
    }

    @Override
    public TramiteDTO guardarTramite(TramiteSaveDTO tramiteSaveDTO) throws Exception {
        try {            
            Tramite res = tramiteRepository.save(convertTramiteSaveDtoTOTramite(tramiteSaveDTO));
            return convertTramiteToTramiteDTO(res);
        } catch (Exception e) {
            throw new Exception("Error inesperado al guardar información de trámite. " + e.getMessage());
        }        
    }

    private TramiteDTO convertTramiteToTramiteDTO(Tramite tramite) throws Exception{         
        try {
            TipoTramiteDTO tipoTramite = TipoTramiteDTO.builder()
                .id(tramite.getTipoTramite().getId())
                .descripcion(tramite.getTipoTramite().getDescripcion())
                .activo(tramite.getActivo())                    
                .build();
            return TramiteDTO.builder()
                .id(tramite.getId())
                .tipoTramiteDTO(tipoTramite)
                .asunto(tramite.getAsunto())
                .correo(tramite.getCorreo())                
                .idTipoRecepcion(tramite.getTipoRecepcion().getId())
                .descTipoRecepcion(tramite.getTipoRecepcion().getDescripcion())
                .build();
        } catch (Exception e) {
            throw new Exception();
        }        
    }

    private Tramite convertTramiteSaveDtoTOTramite(TramiteSaveDTO tramiteSaveDTO) throws Exception {
        try {
            TipoTramite tipoT = tipoTramiteRepository.findById(tramiteSaveDTO.getIdTipoTramite()).get();        
            Dependencia dependencia = dependenciaRepository.findById(tramiteSaveDTO.getIdDependencia()).get();            
            Tramite tramite = Tramite.builder()                    
                    .tipoTramite(tipoT)
                    .fechaRecepcion(tramiteSaveDTO.getFechaRecepcion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())                
                    .asunto(tramiteSaveDTO.getAsunto())
                    .numeroOficio(tramiteSaveDTO.getNumeroOficio())
                    .nombrePeticionario(tramiteSaveDTO.getNombrePeticionario())
                    .descripcion(tramiteSaveDTO.getDescripcion())
                    .activo(tramiteSaveDTO.getActivo() == 1 ? true : false)
                    .fechaCreacionRegistro(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .correo(tramiteSaveDTO.getCorreo())
                    .numerovu(tramiteSaveDTO.getNumerovu())
                    .dependencia(dependencia)
                    .build();
            return tramite;
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
}

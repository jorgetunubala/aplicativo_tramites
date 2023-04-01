package com.unicauca.maestria.computacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.maestria.computacion.dto.TramiteDTO;
import com.unicauca.maestria.computacion.dto.TramiteSaveDTO;
import com.unicauca.maestria.computacion.dto.rest.HttpRespuestaDataTramite;
import com.unicauca.maestria.computacion.dto.rest.HttpRespuestaSave;
import com.unicauca.maestria.computacion.service.TramiteService;

@RestController
@RequestMapping("/api/tramites")
public class TramitesController {
    
    @Autowired
    private TramiteService tramiteService;

    @GetMapping("/conteo")
    public ResponseEntity<Integer> getConteoTramitesActivos() throws Exception{
        Integer totalActivos;
        try {
            totalActivos = tramiteService.getConteoTramitesActivos();            
            return new ResponseEntity<>(totalActivos, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Error inesperado consultanto el total de tramites activos. " + e.getMessage());
        }        
    }

    @GetMapping("/dataTramite")
    public HttpRespuestaDataTramite getDataTramitesActivos() throws Exception{
        List<TramiteDTO> tramites;
        try {
            tramites = tramiteService.getTramites();
            HttpRespuestaDataTramite hDataTramite = new HttpRespuestaDataTramite();
            hDataTramite.setTramiteDTOs(tramites);
            return hDataTramite;
        } catch (Exception e) {
            return new HttpRespuestaDataTramite(e);
        }        
    }

    @PostMapping    
    public HttpRespuestaSave postTramite(@RequestBody TramiteSaveDTO tramiteSaveDTO) {
        TramiteDTO tramiteDTO;
        try {            
            tramiteDTO = tramiteService.guardarTramite(tramiteSaveDTO);
            HttpRespuestaSave hRespuestaSave = new HttpRespuestaSave();
            hRespuestaSave.setTramiteDTO(tramiteDTO);
            return hRespuestaSave;
        } catch (Exception e) {
            return new HttpRespuestaSave(e);
        }    
    }
}

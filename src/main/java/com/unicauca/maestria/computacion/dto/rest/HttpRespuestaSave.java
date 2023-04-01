package com.unicauca.maestria.computacion.dto.rest;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import com.unicauca.maestria.computacion.dto.TramiteDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HttpRespuestaSave extends HttpRespuesta{
   
    private TramiteDTO tramiteDTO;

    public HttpRespuestaSave(Exception e){
        this.mensaje = e.getMessage();
        this.estado = HttpStatus.CONFLICT.name();
        this.estadoCodigo = HttpStatus.CONFLICT.value();
        this.fechaTransaccion = ZonedDateTime.now();
        this.uriRequested = "";
    }
}

package com.unicauca.maestria.computacion.dto.rest;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class HttpRespuesta {
    
    protected String mensaje;
    protected String estado;
    protected int estadoCodigo;
    protected String uriRequested;
    protected ZonedDateTime fechaTransaccion;  
    
    public HttpRespuesta(){
        this.mensaje = HttpStatus.OK.toString();
        this.estado = HttpStatus.OK.name();
        this.estadoCodigo = HttpStatus.OK.value();
        this.fechaTransaccion = ZonedDateTime.now();
        this.uriRequested = "";
    }

    public HttpRespuesta(Exception e){
        this.mensaje = e.getMessage();
        this.estado = HttpStatus.CONFLICT.name();
        this.estadoCodigo = HttpStatus.CONFLICT.value();
        this.fechaTransaccion = ZonedDateTime.now();
        this.uriRequested = "";
    }

    @Override
    public String toString() {
        return "HttpResponse [message=" + mensaje + ", estado=" + estado + ", código estado=" + estadoCodigo + ", uriRequested=" + uriRequested
                + ", Fecha transacción=" + fechaTransaccion + "]";
    }
}

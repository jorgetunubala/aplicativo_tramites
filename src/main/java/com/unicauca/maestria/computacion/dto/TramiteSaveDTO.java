package com.unicauca.maestria.computacion.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TramiteSaveDTO {    
    private Integer idTipoTramite;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fechaRecepcion;
    private Date fechaVencimiento;
    private Date fechaRespuesta;
    private String asunto;
    private String numeroOficio;
    private String nombrePeticionario;
    private String celular;
    private String telefono;
    private String descripcion;
    private Integer activo;    
    private String correo;
    private Integer idTipoRecepcion;
    private Integer idDependencia;
    private Integer numerovu;
    private Integer idTipoPeticionario;    
}

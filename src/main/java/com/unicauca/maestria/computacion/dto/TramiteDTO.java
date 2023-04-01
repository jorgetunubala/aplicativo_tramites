package com.unicauca.maestria.computacion.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TramiteDTO {
    
    private Integer id;
    private TipoTramiteDTO tipoTramiteDTO;
    private String asunto;
    private String correo;
    private Integer idTipoRecepcion;    
    private String descTipoRecepcion;
}

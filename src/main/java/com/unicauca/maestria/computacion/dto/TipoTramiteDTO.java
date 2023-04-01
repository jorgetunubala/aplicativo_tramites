package com.unicauca.maestria.computacion.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoTramiteDTO {
    private int id;
    private String descripcion;
    private Boolean activo;
}

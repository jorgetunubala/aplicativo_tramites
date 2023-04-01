package com.unicauca.maestria.computacion.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.unicauca.maestria.computacion.comun.util.BooleanConverter;

import lombok.Data;

@Entity
@Table(name = "tbl_tipo_tramite")
@Data
public class TipoTramite {
    @Id
    @Column(name = "id_tipo_tramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "vigencia")
    private String vigencia;

    @Convert(converter = BooleanConverter.class)
    @Column(name = "activo", length = 1)
    private Boolean activo;

    @Column(name = "fecha_creacion_registro")
    private LocalDate fechaCreacionRegistro;
}

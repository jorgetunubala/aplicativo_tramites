package com.unicauca.maestria.computacion.domain;

import java.time.LocalDate;

import javax.persistence.*;

import com.unicauca.maestria.computacion.comun.util.BooleanConverter;

import lombok.Data;

@Entity
@Table(name = "tbl_dependencia")
@Data
public class Dependencia {
    @Id
    @Column(name = "id_dependencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;    

    @Column(name = "nombreEncargado")
    private String nombreEncargado;

    @Column(name = "correo_encargado")
    private String correoEncargado;

    @Convert(converter = BooleanConverter.class)
    @Column(name = "activo", length = 1)
    private Boolean activo;

    @Column(name = "fecha_creacion_registro")
    private LocalDate fechaCreacionRegistro;
}

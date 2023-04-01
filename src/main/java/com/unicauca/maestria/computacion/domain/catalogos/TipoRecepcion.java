package com.unicauca.maestria.computacion.domain.catalogos;

import javax.persistence.Table;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cat_tipo_recepcion")
@Data
public class TipoRecepcion {
    
    @Id
    @Column(name = "id_tipo_recepcion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;
}

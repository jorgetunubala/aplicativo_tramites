package com.unicauca.maestria.computacion.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unicauca.maestria.computacion.comun.util.BooleanConverter;
import com.unicauca.maestria.computacion.domain.catalogos.TipoRecepcion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tramite")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tramite {
    @Id
    @Column(name = "id_tramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @Column(name = "fecha_recepcion")
    private LocalDate fechaRecepcion;    

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "numero_oficio")
    private String numeroOficio;

    @Column(name = "nombre_peticionario")
    private String nombrePeticionario;

    @Column(name = "descripcion")
    private String descripcion;

    @Convert(converter = BooleanConverter.class)
    @Column(name = "activo", length = 1)
    private Boolean activo;

    @Column(name = "fecha_creacion_registro")
    private LocalDate fechaCreacionRegistro;

    @Column(name = "correo")
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_recepcion")
    private TipoRecepcion tipoRecepcion;

    @Id
    @Column(name = "numero_vu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer numerovu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;
    
}

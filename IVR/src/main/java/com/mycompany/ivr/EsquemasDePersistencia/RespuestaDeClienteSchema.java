/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */
@Entity
@Table(name = "respuestaDeCliente")
public class RespuestaDeClienteSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @ManyToOne
    @JoinColumn(name = "respuestaPosible_id")
    public RespuestaPosibleSchema respuestaSeleccionada;

    @ManyToOne
    @JoinColumn(name = "llamada_id")
    public LlamadaSchema llamada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(String fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RespuestaPosibleSchema getRespuestaSeleccionada() {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(RespuestaPosibleSchema respuestaSeleccionada) {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public LlamadaSchema getLlamada() {
        return llamada;
    }

    public void setLlamada(LlamadaSchema llamada) {
        this.llamada = llamada;
    }

}

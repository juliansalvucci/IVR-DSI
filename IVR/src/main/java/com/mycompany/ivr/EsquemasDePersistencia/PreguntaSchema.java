/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */
@Entity
@Table(name = "pregunta")
public class PreguntaSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String pregunta;
    public String descripcion;

    @OneToMany(mappedBy = "pregunta")
    public List<RespuestaPosibleSchema> respuesta; //pregunta tiene 1...* respuestaPosible

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    public EncuestaSchema encuesta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RespuestaPosibleSchema> getRespuestas() {
        return respuesta;
    }

    public void setRespuestas(List<RespuestaPosibleSchema> respuesta) {
        this.respuesta = respuesta;
    }

    public EncuestaSchema getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaSchema encuesta) {
        this.encuesta = encuesta;
    }
}

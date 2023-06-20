/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Clases;

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
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String pregunta;
    public String descripcion;

    @OneToMany(mappedBy = "pregunta")
    public List<RespuestaPosible> respuesta;

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    public Encuesta encuesta;

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

    public List<RespuestaPosible> getRespuestas() {
        return respuesta;
    }

    public void setRespuestas(List<RespuestaPosible> respuesta) {
        this.respuesta = respuesta;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Boolean tieneRespuestaPosible(String respuestaPosible) {  //Método para determinar las preguntas relacionadas con la respuesta posible ingresada por parámetro.
        List<RespuestaPosible> respuestasPosibles = this.getRespuestas();
        for (RespuestaPosible respuesta : respuestasPosibles) {
            if (respuesta.toString().equals(respuestaPosible)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}

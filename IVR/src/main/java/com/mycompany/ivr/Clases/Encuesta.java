/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */
@Entity
@Table(name = "encuesta")
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @OneToMany(mappedBy = "encuesta")
    public List<Pregunta> preguntas;

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

    public String getDescripcionEncuesta() {
        return descripcion;
    }

    public void setDescripcionEncuesta(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Boolean esEncuestaDeCliente(String respuestaPosible) {
        List<Pregunta> preguntas = getPreguntas();
        for (Pregunta pregunta : preguntas) {
            Boolean esEncuesta = pregunta.tieneRespuestaPosible(respuestaPosible);
            if (esEncuesta) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public List<String> getDescripcionPreguntas() {
        List<String> descripcionPreguntas = new ArrayList<String>();
        List<Pregunta> preguntas = getPreguntas();
        for (Pregunta pregunta : preguntas) {
            descripcionPreguntas.add(pregunta.getDescripcion());
        }
        return descripcionPreguntas;
    }
}

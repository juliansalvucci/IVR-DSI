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

/**
 *
 * @author jlssa
 */
@Entity
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @OneToMany(mappedBy = "pregunta")
    public List<Pregunta> preguntas;

    public String getDescripcionEncuesta() {
        return descripcion;
    }

    public void setDescripcionEncuesta(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(String fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public List<Pregunta> getPregunta() {
        return preguntas;
    }

    public void setPregunta(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Boolean esEncuestaDeCliente(String respuestaPosible) {
        for (Pregunta pregunta : preguntas) {
            Boolean esEncuesta = pregunta.esEncuestaCliente(respuestaPosible);
            if (esEncuesta) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public List<String> armarEncuesta(){
        List<String> descripcionPreguntas = new ArrayList<String>();
        for(Pregunta pregunta : preguntas){
            descripcionPreguntas.add(pregunta.getDescripcion());
        }
        return descripcionPreguntas;
    }
}

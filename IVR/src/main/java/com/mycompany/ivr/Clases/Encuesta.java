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
    //Asociarción encuesta tiene 1...* preguntas.
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

    //Método para validar si la encuesta pertenece a una llamada a partir del espacio en memoria de una respuestaPosible.
    public Boolean esEncuestaDeCliente(String respuestaPosible) {
        List<Pregunta> preguntas = getPreguntas(); //Consultar los objetos de tipo pregunta asociados.
        for (Pregunta pregunta : preguntas) {
            Boolean esEncuesta = pregunta.tieneRespuestaPosible(respuestaPosible); //Verificar si la pregunta tiene como respuesta posible la ingresada por parámetro.
            if (esEncuesta) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public List<String> getDescripcionPreguntas() { //Obtener descripción de las preguntas asociadas a la encuesta.
        List<String> descripcionPreguntas = new ArrayList<String>();
        List<Pregunta> preguntas = getPreguntas();
        for (Pregunta pregunta : preguntas) {
            descripcionPreguntas.add(pregunta.getDescripcion()); //Delegar responsabilidad a cada pregunta de obtener su descripción.
        }
        return descripcionPreguntas;
    }
}

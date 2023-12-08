/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jlssa
 */

public class EncuestaSchema {

    public String fechaEncuesta;
    public String descripcion;

    public List<PreguntaSchema> preguntas; // Asociarción encuesta tiene 1...* preguntas.

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

    public List<PreguntaSchema> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaSchema> preguntas) {
        this.preguntas = preguntas;
    }

    //Método para validar si la encuesta pertenece a una llamada a partir del espacio en memoria de una respuestaPosible.
    public Boolean esEncuestaDeCliente(String respuestaPosible) {
        List<PreguntaSchema> preguntas = getPreguntas(); //Consultar los objetos de tipo pregunta asociados.
        for (PreguntaSchema pregunta : preguntas) {
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
        List<PreguntaSchema> preguntas = getPreguntas();
        for (PreguntaSchema pregunta : preguntas) {
            descripcionPreguntas.add(pregunta.getDescripcion()); //Delegar responsabilidad a cada pregunta de obtener su descripción.
        }
        return descripcionPreguntas;
    }
}

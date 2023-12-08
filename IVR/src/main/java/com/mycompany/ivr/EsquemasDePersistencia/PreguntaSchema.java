/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.List;

import com.mycompany.ivr.Clases.RespuestaPosible;

/**
 *
 * @author jlssa
 */

public class PreguntaSchema {

    public String pregunta;
    public String descripcion;

    public List<RespuestaPosibleSchema> respuesta; // pregunta tiene 1...* respuestaPosible

    public EncuestaSchema encuesta;

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

    public Boolean tieneRespuestaPosible(String respuestaPosible) {  //Método para determinar las preguntas relacionadas con la respuesta posible ingresada por parámetro.
        List<RespuestaPosibleSchema> respuestasPosibles = this.getRespuestas();
        for (RespuestaPosibleSchema respuesta : respuestasPosibles) {
            if (respuesta.toString().equals(respuestaPosible)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

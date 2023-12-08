/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

/**
 *
 * @author jlssa
 */

public class RespuestaPosibleSchema {

    public String descripcion;
    public String valor; // Puede ser un puntaje del 1 al 10 o un SI o NO.

    public PreguntaSchema pregunta;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PreguntaSchema getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaSchema pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcionRTA() {
        return descripcion;
    }
}

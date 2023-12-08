/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

/**
 *
 * @author jlssa
 */

public class RespuestaDeClienteSchema {

    public String fechaEncuesta;
    public String descripcion;

    public RespuestaPosibleSchema respuestaSeleccionada;

    public LlamadaSchema llamada;

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

    public String getDescripcionRTA() { //Método para obtener respuestas del cliente y la respuesta asignada por el mismo.
        String descripcionRespuestaSeleccionada = this.getRespuestaSeleccionada().getDescripcionRTA();
        return descripcion + " - " + descripcionRespuestaSeleccionada + "_" + this.getRespuestaSeleccionada(); //Se agrega dirección de memoria para luego obtener la encuesta correspondiente.
    }

}

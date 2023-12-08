/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.List;

/**
 *
 * @author jlssa
 */

public class LlamadaSchema {

    private String duracion;

    private ClienteSchema cliente; // llamada tiene 1 cliente.

    private List<CambioEstadoSchema> cambioEstado; // llamada tiene 1...* cambioEstado.

    private List<RespuestaDeClienteSchema> respuestaDeCliente; // llamada tiene 0...* respuestaDeCliente.

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ClienteSchema getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSchema cliente) {
        this.cliente = cliente;
    }

    public List<CambioEstadoSchema> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(List<CambioEstadoSchema> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public List<RespuestaDeClienteSchema> getRespuestaDeCliente() {
        return respuestaDeCliente;
    }

    public void setRespuestaDeCliente(List<RespuestaDeClienteSchema> respuestaDeCliente) {
        this.respuestaDeCliente = respuestaDeCliente;
    }
}

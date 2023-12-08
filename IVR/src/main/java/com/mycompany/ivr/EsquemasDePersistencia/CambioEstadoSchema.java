package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.Date;

public class CambioEstadoSchema {

    private Date fechaHoraInicio;
    private Date fechaHoraFin;

    private EstadoSchema estado; // Asociación simple cambioEstado tiene 1 estado.

    private LlamadaSchema llamada;

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public EstadoSchema getEstado() {
        return estado;
    }

    public void setEstado(EstadoSchema estado) {
        this.estado = estado;
    }

    public LlamadaSchema getLlamada() {
        return llamada;
    }

    public void setLlamada(LlamadaSchema llamada) {
        this.llamada = llamada;
    }

    public String getNombreEstado(){ //Solicitud de nombre a objeto relacionado estado.
        return this.getEstado().getNombre();
    }
}

package com.mycompany.ivr.EsquemasDePersistencia;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cambioEstado")
public class CambioEstadoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    
    @OneToOne
    private EstadoSchema estado;  //Asociación simple cambioEstado tiene 1 estado.

    @ManyToOne()
    @JoinColumn(name = "llamada_id")
    private LlamadaSchema llamada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */
@Entity
@Table(name = "llamada")
public class Llamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String duracion;
    @OneToOne private Cliente cliente;

    @OneToMany(mappedBy = "llamada")
    private List<CambioEstado> cambioEstado;

    @OneToMany(mappedBy = "llamada")
    private List<RespuestaDeCliente> respuestaDeCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CambioEstado> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(List<CambioEstado> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public List<RespuestaDeCliente> getRespuestaDeCliente() {
        return respuestaDeCliente;
    }

    public void setRespuestaDeCliente(List<RespuestaDeCliente> respuestaDeCliente) {
        this.respuestaDeCliente = respuestaDeCliente;
    }

    public Date determinarFechaInicioLlamada()
    {
        CambioEstado primerCambioEstado = null;
        if (!cambioEstado.isEmpty()) {
            primerCambioEstado = cambioEstado.get(0);
        }

        Date fechaHoraInicio = primerCambioEstado.getFechaHoraInicio();

        return fechaHoraInicio;
    }

    public String determinarUltimoEstado() {
        CambioEstado ultimoCambioEstado = null;
        if (!cambioEstado.isEmpty()) {
            int lastIndex = cambioEstado.size() - 1;
            ultimoCambioEstado = cambioEstado.get(lastIndex);
        }
        // DESCARTARÍA EL MÉTODO getFechaHoraInicio porque estoy tomando precisamente el
        return ultimoCambioEstado.getEstado().getNombre();
    }

    public String getNombreClienteDeLlamada() {
        return cliente.getNombreCompleto();
    }

    public List<String> getRespuestas() {
        List<String> respuestas = new ArrayList<String>();
        for (RespuestaDeCliente respuestaDeCliente : this.respuestaDeCliente) {
            respuestas.add(respuestaDeCliente.getDescripcionRTA());
        }

        return respuestas;
    }

    public Boolean esDePeriodo(Date fechaInicio, Date fechaFin) {
        Date fechaDeEstado = determinarFechaInicioLlamada();
        if (fechaDeEstado.before(fechaFin) && fechaDeEstado.after(fechaInicio)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean tieneEncuestaRespondida() {
        if (this.respuestaDeCliente.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}

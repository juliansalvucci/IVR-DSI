/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

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
public class LlamadaSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String duracion;
    
    @OneToOne private ClienteSchema cliente; //llamada tiene 1 cliente.
    
    @OneToMany(mappedBy = "llamada")
    private List<CambioEstadoSchema> cambioEstado; //llamada tiene 1...* cambioEstado.
   
    @OneToMany(mappedBy = "llamada")
    private List<RespuestaDeClienteSchema> respuestaDeCliente;  //llamada tiene 0...* respuestaDeCliente.

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

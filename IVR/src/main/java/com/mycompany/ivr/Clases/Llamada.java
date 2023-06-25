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

    public Date determinarFechaInicioLlamada() //Método para obtener fecha de inicio de una llamada.
    {
        List<CambioEstado> cambiosEstado = this.getCambioEstado(); //La fecha de inicio la contiene la primer instancia de cambioEstado asociada.
        CambioEstado primerCambioEstado = null;  //Inicializar objeto auxiliar de cambio de estado.
        if (!cambiosEstado.isEmpty()) {  
            primerCambioEstado = cambiosEstado.get(0); //Tomar la primer instancia de cambio de estado asociada.
        }

        Date fechaHoraInicio = primerCambioEstado.getFechaHoraInicio(); //Tomar la fecha y hora de incio del cambio de estado encontrado.

        return fechaHoraInicio; //Retornar la fecha y hora encontrada.
    }

    public String determinarUltimoEstado() { //Método para obtener el nombre del último estado de la llamada.
        List<CambioEstado> cambiosEstado = this.getCambioEstado();
        CambioEstado ultimoCambioEstado = null;
        if (!cambiosEstado.isEmpty()) {
            int lastIndex = cambiosEstado.size() - 1;
            ultimoCambioEstado = cambiosEstado.get(lastIndex); //Obtener el último cambio de estado asociado.
        }
        return ultimoCambioEstado.getNombreEstado(); //Retornar el nombre de estado asociado al cambio de estado encontrado.
    }

    public String getNombreClienteDeLlamada() { //Método para obtener el nombre completo del cliente asociado.
        return this.getCliente().getNombreCompleto(); //Solicitar al cliente asociado que retorne su nombre completo.
    }

    public List<String> getRespuestas() { //Obtener respuestas de cliente asociadas a la llamada.
        List<RespuestaDeCliente> respuestasDeCliente = this.getRespuestaDeCliente();
        List<String> respuestas = new ArrayList<String>();
        for (RespuestaDeCliente respuestaDeCliente : respuestasDeCliente) {
            respuestas.add(respuestaDeCliente.getDescripcionRTA());
        }

        return respuestas;
    }

    public Boolean esDePeriodo(Date fechaInicio, Date fechaFin) { //Método para determinar si la llamada corresponde a un periódo establecido.
        Date fechaDeEstado = this.determinarFechaInicioLlamada(); //Obtener la fecha inicial de la llamada para comparar con las establecidas en el periódo.
        if (fechaDeEstado.before(fechaFin) && fechaDeEstado.after(fechaInicio)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean tieneEncuestaRespondida() { //Método para consultar si una llamada tiene encuesta asociada.
        if (this.getRespuestaDeCliente().size() != 0) { //Al no tener relación con la clase encuesta, deberá corroborarlo mediante si tiene respuestas de cliente asociadas.
            return true;
        } else {
            return false;
        }
    }
}

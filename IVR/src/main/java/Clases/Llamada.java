/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 *
 * @author jlssa
 */
@Entity
public class Llamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String duracion;
    private Cliente cliente;

    @OneToMany(mappedBy = "cambioEstado")
    private List<CambioEstado> cambioEstado;

    @OneToMany(mappedBy = "respuestaDeCliente")
    private List<RespuestaDeCliente> respuestaDeCliente;

    EntityManager em;

    public Llamada(EntityManager em) {
        this.em = em;
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

    public Date determinarEstadoInicial() // Cambiar Nombre Ej: determinar fechaInicioLlamada.
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
        return ultimoCambioEstado.getNombreEstado();
    }

    public String getNombreClienteDeLlamada() {
        return cliente.getNombreCompleto();
    }

    // TERMINAR
    public List<String> getRespuestas() {
        List<String> respuestas = new ArrayList<String>();
        for (RespuestaDeCliente respuestaDeCliente : this.respuestaDeCliente) {
            respuestas.add(respuestaDeCliente.getDescripcionRTA());
        }

        return respuestas;
    }

    // MÉTODOS DE LÓGICA DE NEGOCIO.
    public Boolean esDePeriodo(Date fechaInicio, Date fechaFin) {
        Date fechaDeEstado = determinarEstadoInicial();
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

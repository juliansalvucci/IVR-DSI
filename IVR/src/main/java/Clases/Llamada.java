/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
    private Date fechaLlamada;
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

    public void setCambioEstado(List<CambioEstado> cambioEstado) 
    {
        this.cambioEstado = cambioEstado;
    }

    public String determinarEstadoInicial() //Cambiar Nombre Ej: determinar fechaInicioLlamada.
    {
        CambioEstado primerCambioEstado = null;
        if (!cambioEstado.isEmpty()) 
        {
            primerCambioEstado = cambioEstado.get(0);
        }

        Date fechaHoraInicio = primerCambioEstado.getFechaHoraInicio();

        return fechaHoraInicio.toString();
    }

    public void determinarUltimoEstado() 
    {
        CambioEstado ultimoCambioEstado = null;
        if (!cambioEstado.isEmpty()) 
        {
            int lastIndex = cambioEstado.size() - 1;
            ultimoCambioEstado = cambioEstado.get(lastIndex);
        }
        //DESCARTARÍA EL MÉTODO getFechaHoraInicio porque estoy tomando precisamente el último elemento.
        ultimoCambioEstado.getNombreEstado();
    }

    public String getNombreClienteDeLlamada() {
        return cliente.getNombreCompleto();
    }

    // TERMINAR
    public void getRespuestas()
    {
        for(RespuestaDeCliente respuestaDeCliente : this.respuestaDeCliente)
        {
            respuestaDeCliente.getDescripcionRTA();
            respuestaDeCliente.getRespuestaSeleccionada().getDescripcionRTA();
        }
    }
    /* 
    public List<RespuestaDeCliente> getRespuestas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RespuestaDeCliente> cq = cb.createQuery(RespuestaDeCliente.class);
        Root<RespuestaDeCliente> root = cq.from(RespuestaDeCliente.class);

        cq.select(root);

        TypedQuery<RespuestaDeCliente> query = em.createQuery(cq);
        var respuestas = query.getResultList();

        for (RespuestaDeCliente respuestaDeCliente : respuestas) {
            respuestaDeCliente.getDescripcionRTA();
            respuestaDeCliente.getRespuestaSeleccionada().getDescripcionRTA();
        }

        return null;
    }
    */
    public void setRespuestas(List<RespuestaDeCliente> respuestaDeCliente) {
        this.respuestaDeCliente = respuestaDeCliente;
    }

    // MÉTODOS DE LÓGICA DE NEGOCIO.
    public Boolean esDePeriodo(Date fechaInicio, Date fechaFin) {
        if (this.fechaLlamada.before(fechaFin) && this.fechaLlamada.after(fechaInicio)) {
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

    public String getNombreDeClienteLlamada() {
        return cliente.getNombreCompleto();
    }

}

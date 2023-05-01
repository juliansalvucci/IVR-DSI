/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.Date;
import java.util.List;


import Clases.Cliente;
import Clases.Llamada;
import Clases.RespuestaDeCliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author jlssa
 */
public class ControladorConsultarEncuesta 
{
    public Date fechaInicio;
    public Date fechaFin;
    public List<Llamada> listaLlamadas;
    public Llamada llamadaSeleccionada;

    EntityManager em;

    public ControladorConsultarEncuesta(EntityManager em)
    {
        this.em = em;
    }

    public List<Llamada> getListaLlamadas() 
    {
        return listaLlamadas;
    }

    public void tomarFechas(Date fechaInicio, Date fechaFin)
    {
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin; 
    }

    public List<Llamada> buscarLlamadasSinEncuesta() 
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root);

        TypedQuery<Llamada> query = em.createQuery(cq);
        var llamadas = query.getResultList();

        for (Llamada llamada : llamadas) 
        {
            if(llamada.esDePeriodo(this.fechaInicio, this.fechaFin) && llamada.tieneEncuestaRespondida())
            {
                this.listaLlamadas.add(llamada);
            }   
        }

        return this.listaLlamadas;
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada)
    {
        this.llamadaSeleccionada = llamada;
    }

    public Cliente buscarDatosClientes()
    {
        return this.llamadaSeleccionada.getCliente();
    }

    public String getEstadoLlamada()
    {
        return this.llamadaSeleccionada.getEstadoActual().getNombre();
    }

    public List<RespuestaDeCliente> getRTACliente()
    {
        return llamadaSeleccionada.getRespuestas();
    }

    public void generarCSV()
    {

    }

    public void finCU()
    {
        
    }
}

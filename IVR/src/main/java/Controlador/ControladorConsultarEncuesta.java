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
        return query.getResultList();
    }

    public Llamada tomarSeleccionLlamadaConEncuesta()
    {
        return null;
    }

    public Cliente buscarDatosClientes()
    {
        return null;
    }

    public String getEstadoLlamada()
    {
        return "";
    }

    public RespuestaDeCliente getRTACliente()
    {
        return null;
    }

    public void generarCSV()
    {

    }

    public void finCU()
    {
        
    }
}

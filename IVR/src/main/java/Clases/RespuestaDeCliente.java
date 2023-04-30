/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author jlssa
 */
@Entity
public class RespuestaDeCliente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @ManyToOne
    @JoinColumn(name = "respuestaPosible_id")
    public RespuestaPosible respuestaSeleccionada;

    @ManyToOne
    @JoinColumn(name = "llamada_id")
    public Llamada llamada;

    public String getFechaEncuesta() 
    {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(String fechaEncuesta) 
    {
        this.fechaEncuesta = fechaEncuesta;
    }
    
    public String getDescripcionRTA() 
    {
        return descripcion;
    }

    public void setDescripcionRTA(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public RespuestaPosible getRespuestaSeleccionada()
    {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(RespuestaPosible respuestaSeleccionada) 
    {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public Llamada getLlamada() 
    {
        return llamada;
    }

    public void setLlamada(Llamada llamada) 
    {
        this.llamada = llamada;
    }
}

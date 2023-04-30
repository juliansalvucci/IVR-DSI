/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jlssa
 */
public class RespuestaDeCliente 
{
    public String fechaEncuesta;
    public String descripcion;
    public RespuestaPosible respuestaSeleccionada;
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

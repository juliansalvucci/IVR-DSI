/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

/**
 *
 * @author jlssa
 */
public class Llamada 
{
    private String duracion;
    private Cliente cliente;
    private Estado estadoActual;
    private List<RespuestaDeCliente> respuestaDeEncuesta;

    public String getDuracion() 
    {
        return duracion;
    }

    public void setDuracion(String duracion) 
    {
        this.duracion = duracion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Estado getEstadoActual() 
    {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) 
    {
        this.estadoActual = estadoActual;
    }

    public List<RespuestaDeCliente> getRespuestaDeEncuesta() 
    {
        return respuestaDeEncuesta;
    }

    public void setRespuestaDeEncuesta(List<RespuestaDeCliente> respuestaDeEncuesta) 
    {
        this.respuestaDeEncuesta = respuestaDeEncuesta;
    }   
    
    //MÉTODOS DE LÓGICA DE NEGOCIO.
    public void esDePeriodo(String fechaInicio, String fechaFin)
    {

    }

    public Boolean tieneEncuestaRespondida()
    {
        if(this.respuestaDeEncuesta.size() != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

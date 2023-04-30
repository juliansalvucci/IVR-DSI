/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jlssa
 */
public class Llamada 
{
    private String duracion;
    private Cliente cliente;
    private Estado estadoActual;
    private RespuestaDeCliente rtaCliente;

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

    public RespuestaDeCliente getRespuestas() 
    {
        return rtaCliente;
    }

    public void setRespuestas(RespuestaDeCliente rtaCliente) 
    {
        this.rtaCliente = rtaCliente;
    }       
}

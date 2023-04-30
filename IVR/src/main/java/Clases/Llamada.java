/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author jlssa
 */
@Entity
public class Llamada 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String duracion;
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estadoActual;

    @OneToMany(mappedBy = "respuestaDeCliente")
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

    public List<RespuestaDeCliente> getRespuestas() 
    {
        return respuestaDeEncuesta;
    }

    public void setRespuestas(List<RespuestaDeCliente> respuestaDeEncuesta) 
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

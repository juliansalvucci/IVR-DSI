package com.mycompany.ivr.Clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cambioEstado")
public class CambioEstado 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    @OneToOne private Estado estado;

    @ManyToOne()
    @JoinColumn(name = "llamada_id")
    private Llamada llamada;

    public Date getFechaHoraInicio() 
    {
        return fechaHoraInicio;
    }
    public void setFechaHoraInicio(Date fechaHoraInicio) 
    {
        this.fechaHoraInicio = fechaHoraInicio;
    }
    public Date getFechaHoraFin() 
    {
        return fechaHoraFin;
    }
    public void setFechaHoraFin(Date fechaHoraFin) 
    {
        this.fechaHoraFin = fechaHoraFin;
    }
    public String getNombreEstado() 
    {
        return estado.getNombre();
    }

    public Estado getEstado()
    {
        return estado;
    }

    public void setEstado(Estado estado) 
    {
        this.estado = estado;
    }
}

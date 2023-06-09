package Clases;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CambioEstado 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private Estado estado;

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
    public Estado getEstado() 
    {
        return estado;
    }
    public void setEstado(Estado estado) 
    {
        this.estado = estado;
    }
}

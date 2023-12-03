package com.mycompany.ivr.Clases.FabricacionPura.Iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces.IIterator;

public class IteradorLlamada implements IIterator {

    public int actual;
    public Llamada llamadaActual;
    public List<Llamada> llamadas = new ArrayList<>();
    public Date fechaInicio;
    public Date fechaFin;

    public IteradorLlamada(List<Llamada> llamadas, Date fechaInicio, Date fechaFin) {
        this.llamadas = llamadas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public void primero() {
        this.actual = 0;
    }

    @Override
    public void siguiente() {
        this.actual = this.actual + 1;
    }

    @Override
    public Object actual() {
        this.llamadaActual = this.llamadas.get(actual);
        if(this.cumpleFiltros()){
            return this.llamadas.get(actual);
        }else{
            return null;
        }
        
    }

    @Override
    public boolean haTerminado() {
        if (this.llamadas.size() == this.actual) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cumpleFiltros() {
        if (llamadaActual.esDePeriodo(this.getFechaInicio(), this.getFechaFin())
                && llamadaActual.tieneEncuestaRespondida()) {
            return true;
        } else {
            return false;
        }
    }
}

package com.mycompany.ivr.Clases.FabricacionPura.Iterator;

import java.util.List;

import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces.IIterator;

public class IteradorLlamada implements IIterator {

    public int actual;
    public List<Llamada> elementos;

    @Override
    public void primero() {
        this.actual = 0;
    }

    @Override
    public void siguiente() {
        this.actual = this.actual + 1;
    }

    @Override
    public Object actua() {
        return this.elementos.get(actual);
    }

    @Override
    public boolean haTerminado() {
        if (this.elementos.size() == this.actual) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cumpleFiltro(Object filtros) {
        /* 
        for (Llamada llamada : elementos) { // Recorrer cada llamada del listado obtenido.
            if (llamada.esDePeriodo(filtros.fechaInicio, this.getFechaFin()) && llamada.tieneEncuestaRespondida()) {
                return true;// Si la llamada esta comprendida en el periódo establecido y
                                                      // tiene encuesta asociada, agregarla a la lista de llamadas.
            }
        }
        */
        return true;
    }
}

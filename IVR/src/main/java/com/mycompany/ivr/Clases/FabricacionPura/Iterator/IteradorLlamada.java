package com.mycompany.ivr.Clases.FabricacionPura.Iterator;

import java.util.List;

import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces.IIterator;

public class IteradorLlamada implements IIterator {

    public int actual;
    public List<Llamada> elementos;

    @Override
    public void primero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primero'");
    }

    @Override
    public void siguiente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'siguiente'");
    }

    @Override
    public Object actua() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actua'");
    }

    @Override
    public boolean haTerminado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'haTerminado'");
    }

    @Override
    public boolean cumpleFiltro(Object[] filtros) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cumpleFiltro'");
    }
}

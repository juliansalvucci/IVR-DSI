package com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces;

import java.util.List;

public interface IIterator {
    public void primero();

    public void siguiente();

    public Object actua();

    public boolean haTerminado();

    public boolean cumpleFiltro(List<Object> filtros);
}

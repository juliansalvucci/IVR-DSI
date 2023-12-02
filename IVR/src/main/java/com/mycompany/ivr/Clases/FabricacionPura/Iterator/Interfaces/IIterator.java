package com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces;

public interface IIterator {
    public void primero();

    public void siguiente();

    public Object actua();

    public boolean haTerminado();

    public boolean cumpleFiltro(Object filtros);
}

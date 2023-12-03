package com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces;

public interface IIterator {
    public void primero();

    public void siguiente();

    public Object actual();

    public boolean haTerminado();

    public boolean cumpleFiltros();
}

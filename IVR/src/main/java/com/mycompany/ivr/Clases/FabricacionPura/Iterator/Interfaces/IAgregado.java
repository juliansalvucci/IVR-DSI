package com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces;

import java.util.List;

public interface IAgregado {
    public IIterator crearIterador(List<Object> elementos);
}
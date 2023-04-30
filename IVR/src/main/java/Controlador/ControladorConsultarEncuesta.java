/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;

import Clases.Llamada;

/**
 *
 * @author jlssa
 */
public class ControladorConsultarEncuesta 
{
    public String fechaInicio;
    public String fechaFin;
    public List<Llamada> listaLlamadas;

    public List<Llamada> getListaLlamadas() 
    {
        return listaLlamadas;
    }

    public void tomarFechas(String fechaInicio, String fechaFin)
    {
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin; 
    }

    public List<Llamada> buscarLlamadasSinEncuesta(){
        return listaLlamadas;
    }

    
}

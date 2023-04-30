/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

/**
 *
 * @author jlssa
 */
public class Encuesta 
{
    public String fechaEncuesta;
    public String descripcion;
    public List<Pregunta> pregunta;
    
    public String getDescripcionEncuesta() 
    {
        return descripcion;
    }

    public void setDescripcionEncuesta(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    public String getFechaEncuesta() 
    {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(String fechaEncuesta) 
    {
        this.fechaEncuesta = fechaEncuesta;
    }

    public List<Pregunta> getPregunta()
    {
        return pregunta;
    }

    public void setPregunta(List<Pregunta> pregunta) 
    {
        this.pregunta = pregunta;
    }
}

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
public class Pregunta 
{
    public String pregunta;
    public String descripcion;
    public List<RespuestaPosible> respuesta;
    public Encuesta encuesta;
    
    public String getPregunta() 
    {
        return pregunta;
    }

    public void setPregunta(String pregunta) 
    {
        this.pregunta = pregunta;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public List<RespuestaPosible> getRespuesta() 
    {
        return respuesta;
    }

    public void setRespuesta(List<RespuestaPosible> respuesta) 
    {
        this.respuesta = respuesta;
    }

    public Encuesta getEncuesta() 
    {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) 
    {
        this.encuesta = encuesta;
    }

}

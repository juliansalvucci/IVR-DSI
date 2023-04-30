/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jlssa
 */
public class RespuestaPosible 
{
    public String descripcion;
    public String valor; //Puede ser un puntaje del 1 al 10 o un SI o NO.
    public Pregunta pregunta;
    
    public String getDescripcionRTA() 
    {
        return descripcion;
    }

    public void setDescripcionRTA(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    public String getValor() 
    {
        return valor;
    }

    public void setValor(String valor) 
    {
        this.valor = valor;
    }

    public Pregunta getPregunta() 
    {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) 
    {
        this.pregunta = pregunta;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jlssa
 */

@Entity
public class RespuestaPosible 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String descripcion;
    public String valor; //Puede ser un puntaje del 1 al 10 o un SI o NO.
    
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
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

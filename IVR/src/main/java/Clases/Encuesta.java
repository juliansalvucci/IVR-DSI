/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 *
 * @author jlssa
 */
@Entity
public class Encuesta 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @OneToMany(mappedBy = "pregunta")
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

    public Boolean esEncuestaDeCliente(RespuestaPosible respuestaPosible)
    {
        return respuestaPosible.getPregunta().esEncuestaCliente(respuestaPosible);
    }
}

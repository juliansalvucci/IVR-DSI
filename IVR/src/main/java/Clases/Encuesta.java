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
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fechaEncuesta;
    public String descripcion;

    @OneToMany(mappedBy = "pregunta")
    public List<Pregunta> preguntas;

    public String getDescripcionEncuesta() {
        return descripcion;
    }

    public void setDescripcionEncuesta(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(String fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public List<Pregunta> getPregunta() {
        return preguntas;
    }

    public void setPregunta(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Boolean esEncuestaDeCliente(String respuestaPosible) {
        for (Pregunta pregunta : preguntas) {
            Boolean esEncuesta = pregunta.esEncuestaCliente(respuestaPosible);
            if (esEncuesta) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

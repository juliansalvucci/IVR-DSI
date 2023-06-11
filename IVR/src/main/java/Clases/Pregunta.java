/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author jlssa
 */
@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String pregunta;
    public String descripcion;

    @OneToMany(mappedBy = "respuestaPosible")
    public List<RespuestaPosible> respuesta = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    public Encuesta encuesta;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RespuestaPosible> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<RespuestaPosible> respuesta) {
        this.respuesta = respuesta;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Boolean esEncuestaCliente(String respuestaPosible) {
        for (RespuestaPosible respuesta : respuesta) {
            if (respuesta.getDescripcionRTA() == respuestaPosible) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}

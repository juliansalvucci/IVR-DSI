/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.EsquemasDePersistencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */

@Entity
@Table(name = "respuestaPosible")
public class RespuestaPosibleSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String descripcion;
    public String valor; // Puede ser un puntaje del 1 al 10 o un SI o NO.

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    public PreguntaSchema pregunta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PreguntaSchema getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaSchema pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcionRTA() {
        return descripcion;
    }
}

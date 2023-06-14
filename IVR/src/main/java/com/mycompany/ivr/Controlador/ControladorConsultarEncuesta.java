/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

import com.mycompany.ivr.Clases.Encuesta;
import com.mycompany.ivr.Clases.Llamada;
import com.opencsv.CSVWriter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jlssa
 */
public class ControladorConsultarEncuesta {
    public Date fechaInicio;
    public Date fechaFin;
    public List<Llamada> listaLlamadas;
    public List<Encuesta> encuestasDeLlamadas;
    public Llamada llamadaSeleccionada;
    public String nombreCliente;
    public String ultimoEstadoLlamada;
    public String duracionLlamada;
    public String descripcionEncuesta;
    public List<String> respuestas;
    public List<String> preguntas;
    public Encuesta encuesta;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Llamada> getListaLlamadas() {
        return listaLlamadas;
    }

    public void setListaLlamadas(List<Llamada> listaLlamadas) {
        this.listaLlamadas = listaLlamadas;
    }

    public List<Encuesta> getEncuestasDeLlamadas() {
        return encuestasDeLlamadas;
    }

    public void setEncuestasDeLlamadas(List<Encuesta> encuestasDeLlamadas) {
        this.encuestasDeLlamadas = encuestasDeLlamadas;
    }

    public Llamada getLlamadaSeleccionada() {
        return llamadaSeleccionada;
    }

    public void setLlamadaSeleccionada(Llamada llamadaSeleccionada) {
        this.llamadaSeleccionada = llamadaSeleccionada;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getUltimoEstadoLlamada() {
        return ultimoEstadoLlamada;
    }

    public void setUltimoEstadoLlamada(String ultimoEstadoLlamada) {
        this.ultimoEstadoLlamada = ultimoEstadoLlamada;
    }

    public String getDuracionLlamada() {
        return duracionLlamada;
    }

    public void setDuracionLlamada(String duracionLlamada) {
        this.duracionLlamada = duracionLlamada;
    }

    public String getDescripcionEncuesta() {
        return descripcionEncuesta;
    }

    public void setDescripcionEncuesta(String descripcionEncuesta) {
        this.descripcionEncuesta = descripcionEncuesta;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    EntityManager em;

    public ControladorConsultarEncuesta(EntityManager em) {
        this.em = em;
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin) {
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);
    }

    public void buscarLlamadasConEncuesta() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root);

        TypedQuery<Llamada> query = em.createQuery(cq);
        var llamadas = query.getResultList();

        for (Llamada llamada : llamadas) {
            if (llamada.esDePeriodo(this.fechaInicio, this.fechaFin) && llamada.tieneEncuestaRespondida()) {
                this.listaLlamadas.add(llamada);
            }
        }

        this.setListaLlamadas(listaLlamadas);
        ;
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) {
        this.setLlamadaSeleccionada(llamada);
    }

    public void obtenerDatosLlamada() {
        String nombreCliente = this.llamadaSeleccionada.getCliente().getNombreCompleto();
        String ultimoEstadoLlamada = this.llamadaSeleccionada.determinarUltimoEstado();
        String duracionLlamada = this.llamadaSeleccionada.getDuracion();

        this.setNombreCliente(nombreCliente);
        this.setUltimoEstadoLlamada(ultimoEstadoLlamada);
        this.setDuracionLlamada(duracionLlamada);
    }

    public void obtenerDatosEncuesta() {
        List<String> respuestas = this.llamadaSeleccionada.getRespuestas();
        this.setRespuestas(respuestas);
    }

    public void buscarEncuestaAsociada() {
        String respuesta = this.respuestas.get(0);
        String[] partes = respuesta.split("_");
        String respuestaPosible = partes[1];

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Encuesta> cq = cb.createQuery(Encuesta.class);
        Root<Encuesta> root = cq.from(Encuesta.class);

        cq.select(root);

        TypedQuery<Encuesta> query = em.createQuery(cq);
        this.encuestasDeLlamadas = query.getResultList();

        for (Encuesta encuesta : this.encuestasDeLlamadas) {
            Boolean esEncuesta = encuesta.esEncuestaDeCliente(respuestaPosible);
            if (esEncuesta) {
                this.setEncuesta(encuesta);
            }
        }
    }

    public void armarEncuesta() {
        String descripcionEncuesta = this.encuesta.getDescripcionEncuesta();
        List<String> preguntas = this.encuesta.armarEncuesta();

        this.setDescripcionEncuesta(descripcionEncuesta);
        this.setPreguntas(preguntas);
    }

    public void tomarSalida(String opcion) {
        if (opcion.equals("CSV")) {
            generarCSV();
        }
    }

    public void generarCSV() {
        String csvFile = "ruta/al/archivo.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = { this.nombreCliente, this.ultimoEstadoLlamada, this.duracionLlamada };
            csvWriter.writeNext(encabezados);

            ArrayList<String> datos = new ArrayList<>();

            for (int i = 0; i < this.respuestas.size(); i++) {
                String fila = this.respuestas.get(i);
                datos.add(fila);
                csvWriter.writeNext(datos.toArray(new String[0]));
            }

            /*
             * String[] datos1 = { "Juan", "Pérez", "30" };
             * csvWriter.writeNext(datos1);
             * 
             * String[] datos2 = { "María", "Gómez", "25" };
             * csvWriter.writeNext(datos2);
             */

            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finCU() {
        System.exit(0); // Finaliza la ejecución del programa sin errores.
    }
}

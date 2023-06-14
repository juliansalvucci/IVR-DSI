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
    public String opcion;

    EntityManager em;

    public ControladorConsultarEncuesta(EntityManager em) {
        this.em = em;
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public List<Llamada> buscarLlamadasConEncuesta() {
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

        return this.listaLlamadas;
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) {
        this.llamadaSeleccionada = llamada;
    }

    public void obtenerDatosLlamada() {
        this.nombreCliente = this.llamadaSeleccionada.getCliente().getNombreCompleto();
        this.ultimoEstadoLlamada = this.llamadaSeleccionada.determinarUltimoEstado();
        this.duracionLlamada = this.llamadaSeleccionada.getDuracion();
    }

    public void obtenerDatosEncuesta() {
        this.respuestas = this.llamadaSeleccionada.getRespuestas();
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
                this.encuesta = encuesta;
            }
        }
    }

    public void armarEncuesta() {
        this.descripcionEncuesta = this.encuesta.getDescripcionEncuesta();
        this.preguntas = this.encuesta.armarEncuesta();
    }

    public void tomarSalida(String opcion) {
        this.opcion = opcion;
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

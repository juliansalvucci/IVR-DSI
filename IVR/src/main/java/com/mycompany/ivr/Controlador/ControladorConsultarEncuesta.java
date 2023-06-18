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
//import com.mycompany.ivr.Vista.PantallaConsultarEncuesta;
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
    public List<Llamada> listaLlamadas = new ArrayList<>();
    public Llamada llamadaSeleccionada;
    public String nombreCliente;
    public String ultimoEstadoLlamada;
    public String duracionLlamada;
    public String descripcionEncuesta;
    public List<String> respuestas;
    public List<String> preguntas;
    public Encuesta encuesta;
    
    // Métodos GET y SET
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

    // PERSISTENCIA.
    EntityManager em; // Entity manager para materializar objetos desde base de datos.

    public ControladorConsultarEncuesta(EntityManager em) {
        this.em = em;
    }

    // LÓGICA DE NEGOCIO.
    public void tomarPeriodo(Date fechaInicio, Date fechaFin) { // Tomar periodo para filtar la consulta de registros de
                                                                // llamadas.
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);
    }

    public void buscarLlamadasConEncuesta() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root); // Obtener llamadas desde base de datos.

        TypedQuery<Llamada> query = em.createQuery(cq);
        List<Llamada> llamadas = query.getResultList();

        for (Llamada llamada : llamadas) {
            System.out.println(llamada);
            if (llamada.esDePeriodo(this.getFechaInicio(), this.getFechaFin()) && llamada.tieneEncuestaRespondida()) {
                this.getListaLlamadas().add(llamada);
                System.out.println("LLAMDA ENCONTRADA");
            }
        }

        this.setListaLlamadas(listaLlamadas);
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) { // Tomar selección de llamada con encuesta.
        this.setLlamadaSeleccionada(llamada);
    }

    public void obtenerDatosLlamada() {
        String nombreCliente = this.getLlamadaSeleccionada().getCliente().getNombreCompleto(); // Obtener nombre de
                                                                                               // cliente.
        String ultimoEstadoLlamada = this.getLlamadaSeleccionada().determinarUltimoEstado(); // Obtener nombre del
                                                                                             // último estado.
        String duracionLlamada = this.getLlamadaSeleccionada().getDuracion(); // Obtener duración.

        this.setNombreCliente(nombreCliente);
        this.setUltimoEstadoLlamada(ultimoEstadoLlamada);
        this.setDuracionLlamada(duracionLlamada);
    }

    public void obtenerDatosEncuesta() {
        List<String> respuestas = this.getLlamadaSeleccionada().getRespuestas(); // Obtener respuestas del cliente y
                                                                                 // posibles.
        this.setRespuestas(respuestas);
    }

    public void buscarEncuestaAsociada() {
        String respuesta = this.getRespuestas().get(0); // Toma una respuesta cualquiera, en este caso, la primera.
        String[] partes = respuesta.split("_"); // Divide la cadena a partir del caracter "_".
        String respuestaPosible = partes[1]; // Toma la parte siguiente del caracter "_", la cual representa a una
                                             // respuesta posible y nos permitirá, a través de su instancia, identificar
                                             // la encuesta correspondiente.

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Encuesta> cq = cb.createQuery(Encuesta.class);
        Root<Encuesta> root = cq.from(Encuesta.class);

        cq.select(root); // Se levantan en memoria todas las encuestas.

        TypedQuery<Encuesta> query = em.createQuery(cq);
        List<Encuesta> encuestas = query.getResultList();

        for (Encuesta encuesta : encuestas) { // Recorrer cada encuesta.
            Boolean esEncuesta = encuesta.esEncuestaDeCliente(respuestaPosible); // Verificar si es encuesta de cliente,
                                                                                 // a partir del espacio en memoria de
                                                                                 // respuesta posible.
            if (esEncuesta) { // Si es encuesta de cliente.
                this.setEncuesta(encuesta); // Guardarla como atributo del gestor.
            }
        }
    }

    public void armarEncuesta() { // Obtengo la información restante para obtener la encuesta completa.
        String descripcionEncuesta = this.getEncuesta().getDescripcionEncuesta();
        List<String> preguntas = this.getEncuesta().getDescripcionPreguntas();

        this.setDescripcionEncuesta(descripcionEncuesta);
        this.setPreguntas(preguntas);
    }

    public void tomarSalida(String opcion) { // Obtiene la opción de generación de informe.
        if (opcion.equals("CSV")) {
            this.generarCSV();
        }
    }

    public void generarCSV() { // Método para generar archivo excel.
        String csvFile = "C:\\Users\\jlssa\\Documents\\archivo.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = { this.getNombreCliente(), this.getUltimoEstadoLlamada(),
                    this.getDuracionLlamada() };
            csvWriter.writeNext(encabezados);

            ArrayList<String> datos = new ArrayList<>();

            for (int i = 0; i < this.getRespuestas().size(); i++) {

                String respuesta = this.getRespuestas().get(i);
                String pregunta = this.getPreguntas().get(i);
                String[] partes = respuesta.split("_");
                String fila = pregunta + " | " + partes[0];

                datos.add(fila);
            }

            for (String dato : datos) {
                csvWriter.writeNext(new String[] { dato });
            }

            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finCU() {
        System.exit(0); // Finaliza la ejecución del programa sin errores.
    }
}

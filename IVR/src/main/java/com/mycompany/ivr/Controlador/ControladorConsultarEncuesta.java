/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mycompany.ivr.Clases.Encuesta;
import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Vista.PantallaConsultarEncuesta;
import com.opencsv.CSVWriter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Desktop;

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
    public List<String> respuestas = new ArrayList<>();
    public List<String> preguntas = new ArrayList<>();
    public Encuesta encuesta;
    public PantallaConsultarEncuesta pantallaConsultarEncuesta;

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

    public PantallaConsultarEncuesta getPantallaConsultarEncuesta() {
        return pantallaConsultarEncuesta;
    }

    public void setPantallaConsultarEncuesta(PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.pantallaConsultarEncuesta = pantallaConsultarEncuesta;
    }

    // PERSISTENCIA.
    EntityManager em; // Entity manager para materializar objetos desde base de datos.

    public ControladorConsultarEncuesta(EntityManager em, PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.em = em;
        this.setPantallaConsultarEncuesta(pantallaConsultarEncuesta);
    }

    // LÓGICA DE NEGOCIO.

    public Boolean opcionConsultarEncuesta() {
        return true;
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin) { // Tomar periodo para filtar la consulta de registros de
                                                                // llamadas.
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);

        this.buscarLlamadasConEncuesta();
    }

    public void buscarLlamadasConEncuesta() {
        this.getListaLlamadas().clear();
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
        this.getPantallaConsultarEncuesta().mostrarLlamadasConEncuestaParaSeleccion();
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) { // Tomar selección de llamada con encuesta.

        this.getRespuestas().clear();
        this.getPreguntas().clear();

        this.setLlamadaSeleccionada(llamada);
        this.obtenerDatosLlamada();
        this.obtenerDatosEncuesta();
        this.buscarEncuestaAsociada();
        this.armarEncuesta();
        this.getPantallaConsultarEncuesta().mostrarEncuesta();
        this.getPantallaConsultarEncuesta().mostrarOpcionesSalida();

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
        switch (opcion) {
            case "CSV":
                generarCSV();
                break;
            case "Imprimir":
                imprimir();
                break;
            default:
                System.out.println("Opción no válida");
                break;
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

    public void imprimir() {
        // Ruta del archivo PDF de salida
        String filePath = "C:\\Users\\jlssa\\Documents\\archivo.pdf";

        try (PDDocument document = new PDDocument()) {
            // Crear una nueva página en el documento
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Crear un objeto PDPageContentStream para escribir el contenido en la página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Configurar la fuente y el tamaño del texto
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Escribir texto en la página
            contentStream.beginText();
            float startY = 700; // Posición vertical inicial
            float lineHeight = 15; // Altura de línea

            contentStream.newLineAtOffset(100, startY);
            contentStream.showText("#################### DATOS DE LLAMADA ####################");
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Cliente: " + this.getNombreCliente());
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Estado actual: " + this.getUltimoEstadoLlamada());
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Duración: " + this.getDuracionLlamada());

            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("########### DETALLE DE PREGUNTAS Y RESPUESTAS ###########");
            for (int i = 0; i < this.getRespuestas().size(); i++) {

                String respuesta = this.getRespuestas().get(i);
                String pregunta = this.getPreguntas().get(i);
                String[] partes = respuesta.split("_");

                contentStream.newLineAtOffset(0, -lineHeight);
                contentStream.newLineAtOffset(0, -lineHeight);
                contentStream.showText(pregunta + " | " + partes[0]);
            }

            contentStream.endText();

            // Cerrar el objeto PDPageContentStream
            contentStream.close();

            // Guardar el documento como archivo PDF
            document.save(filePath);

            System.out.println("¡Archivo PDF generado correctamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File(filePath);
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finCU() {
        System.exit(0); // Finaliza la ejecución del programa sin errores.
    }
}

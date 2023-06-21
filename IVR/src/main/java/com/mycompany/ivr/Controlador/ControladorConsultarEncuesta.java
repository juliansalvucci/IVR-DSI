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
    //ATRIBUTOS
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

    //CONSTRUCTOR.
    public ControladorConsultarEncuesta(EntityManager em, PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.em = em;
        this.setPantallaConsultarEncuesta(pantallaConsultarEncuesta); //Dependencia de gestor a pantalla.
    }

    // LÓGICA DE NEGOCIO.

    public Boolean opcionConsultarEncuesta() { //Método que acciona el filtro por periódo.
        return true;
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin) {  //Método que establece las fechas del periódo para el filtrado de llamadas.
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);

        this.buscarLlamadasConEncuesta(); //Invocación de método para buscar las llamadas con encuesta.
    }

    public void buscarLlamadasConEncuesta() { 
        this.getListaLlamadas().clear(); //Vaciar lista de llamadas para no mezclar con contenido previo.
        //Levantar desde BD a memoria todos los objetos de tipo llamada.//
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root); 

        TypedQuery<Llamada> query = em.createQuery(cq);
        List<Llamada> llamadas = query.getResultList();
        //Fin desmaterialización llamadas//

        for (Llamada llamada : llamadas) { //Recorrer cada llamada del listado obtenido.
            if (llamada.esDePeriodo(this.getFechaInicio(), this.getFechaFin()) && llamada.tieneEncuestaRespondida()) {
                this.getListaLlamadas().add(llamada); //Si la llamada esta comprendida en el periódo establecido y tiene encuesta asociada, agregarla a la lista de llamadas.
            }
        }

        this.setListaLlamadas(listaLlamadas);  //Establecer valor de la lista de llamadas.
        this.getPantallaConsultarEncuesta().mostrarLlamadasConEncuestaParaSeleccion(); //Solicitar a la pantalla que muestre el listado de llamadas obtenido.
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) { // Tomar selección de llamada con encuesta.

        this.getRespuestas().clear(); //Vaciar lista de respuestas para no mezclar con contenido previo.
        this.getPreguntas().clear(); //Vaciar lista de preguntas para no mezclar con contenido previo.

        this.setLlamadaSeleccionada(llamada); //Establecer llamada seleccionada.
        this.obtenerDatosLlamada(); //Invocar método para obtener datos de llamada.
        this.obtenerDatosEncuesta(); //Invocar método para obtener datos de la encuesta correspondiente a la llamada.
        this.buscarEncuestaAsociada(); //Buscar la encuesta correspondiente a los datos de encuesta obtenidos.
        this.armarEncuesta(); //Obtener datos restantes de la encuesta para completar su contenido.


        this.getPantallaConsultarEncuesta().mostrarEncuesta();  //Solicitar a la pantalla que muestre la encuesta finalmente formada.
        this.getPantallaConsultarEncuesta().mostrarOpcionesSalida(); //Solicitar a la pantalla que ahbilite las opciones de salida.

    }

    public void obtenerDatosLlamada() {
        String nombreCliente = this.getLlamadaSeleccionada().getCliente().getNombreCompleto(); // Obtener nombre de cliente.
        String ultimoEstadoLlamada = this.getLlamadaSeleccionada().determinarUltimoEstado(); // Obtener nombre del último estado.
        String duracionLlamada = this.getLlamadaSeleccionada().getDuracion(); // Obtener duración.

        this.setNombreCliente(nombreCliente);
        this.setUltimoEstadoLlamada(ultimoEstadoLlamada);
        this.setDuracionLlamada(duracionLlamada);
    }

    public void obtenerDatosEncuesta() {
        List<String> respuestas = this.getLlamadaSeleccionada().getRespuestas(); // Obtener respuestas del cliente y posibles.
        this.setRespuestas(respuestas); //Establecer atributo de gestor "respuestas".
    }

    public void buscarEncuestaAsociada() {
        String respuesta = this.getRespuestas().get(0); // Toma una respuesta cualquiera, en este caso, la primera.
        String[] partes = respuesta.split("_"); // Divide la cadena a partir del caracter "_".
        String respuestaPosible = partes[1]; // Toma la parte siguiente del caracter "_", la cual representa a una
                                             // respuesta posible y nos permitirá, a través de su instancia, identificar
                                             // la encuesta correspondiente.
        //Levantar desde BD a memoria todos los objetos de tipo Encuesta.//
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Encuesta> cq = cb.createQuery(Encuesta.class);
        Root<Encuesta> root = cq.from(Encuesta.class);

        cq.select(root); // Se levantan en memoria todas las encuestas.

        TypedQuery<Encuesta> query = em.createQuery(cq);
        List<Encuesta> encuestas = query.getResultList();
        //Fin desmaterialización encuestas//

        for (Encuesta encuesta : encuestas) { // Recorrer listado de encuestas obtenido.
            Boolean esEncuesta = encuesta.esEncuestaDeCliente(respuestaPosible); // Verificar si es encuesta de cliente,
                                                                                 // a partir del espacio en memoria de
                                                                                 // respuesta posible.
            if (esEncuesta) { // Si es encuesta de cliente.
                this.setEncuesta(encuesta); //Establcer atributo de gestor "encuesta".
            }
        }
    }

    public void armarEncuesta() { // Obtengo la información restante para obtener la encuesta completa.

        String descripcionEncuesta = this.getEncuesta().getDescripcionEncuesta(); //Obtener descripción de encuesta.
        List<String> preguntas = this.getEncuesta().getDescripcionPreguntas(); //Obtener preguntas de la encuesta.
        //Establecer atributos de gestor "descripcionEncuesta" y "preguntas".
        this.setDescripcionEncuesta(descripcionEncuesta);
        this.setPreguntas(preguntas);
    }

    public void tomarSalida(String opcion) { // Obtiene la opción de generación de informe.
        switch (opcion) {
            case "CSV": //Si la opción es CSV, invocar método para generar archivo CSV.
                generarCSV();
                break;
            case "Imprimir": //Si la opción es imprimir. invocar método imprimir.
                imprimir();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void generarCSV() { // Método para generar archivo CSV.
        String csvFile = "C:\\Users\\jlssa\\Documents\\archivo.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = { this.getNombreCliente(), this.getUltimoEstadoLlamada(),
                    this.getDuracionLlamada() };
            csvWriter.writeNext(encabezados);

            ArrayList<String> datos = new ArrayList<>();

            //Escribir celdas de archivo CSV.
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

    public void imprimir() { //Método para generar archivo PDF para impresión.
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

            //Establecer cabecera de PDF.
            contentStream.newLineAtOffset(100, startY);
            contentStream.showText("#################### DATOS DE LLAMADA ####################");
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Cliente: " + this.getNombreCliente());
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Estado actual: " + this.getUltimoEstadoLlamada());
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Duración: " + this.getDuracionLlamada());

            //Establecer detalle con las preguntas y respuestas respectivas.
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

        try {  //Abrir PDF en pestaña de navegador.
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

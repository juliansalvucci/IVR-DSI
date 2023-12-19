/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycompany.ivr.Clases.Encuesta;
import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.IteradorLlamada;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces.IAgregado;
import com.mycompany.ivr.Clases.FabricacionPura.Iterator.Interfaces.IIterator;
import com.mycompany.ivr.Clases.FabricacionPura.Singleton.GeneradorCSV;
import com.mycompany.ivr.Clases.FabricacionPura.Singleton.Impresor;
import com.mycompany.ivr.Persistencia.Persistencia;
import com.mycompany.ivr.Vista.PantallaConsultarEncuesta;

import javax.persistence.EntityManager;

/**
 *
 * @author jlssa
 */
public class ControladorConsultarEncuesta implements IAgregado {
    // ATRIBUTOS
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
    public Encuesta encuestaDeLalamada;
    public PantallaConsultarEncuesta pantallaConsultarEncuesta;

    // MÉTODOS GET y SET
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

    public Encuesta getEncuestaDeLaLlamada() {
        return encuestaDeLalamada;
    }

    public void setEncuestaDeLaLlamada(Encuesta encuestaDeLalamada) {
        this.encuestaDeLalamada = encuestaDeLalamada;
    }

    public PantallaConsultarEncuesta getPantallaConsultarEncuesta() {
        return pantallaConsultarEncuesta;
    }

    public void setPantallaConsultarEncuesta(PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.pantallaConsultarEncuesta = pantallaConsultarEncuesta;
    }

    // PERSISTENCIA.
    EntityManager em; // Entity manager para materializar objetos desde base de datos.
    private static ControladorConsultarEncuesta instance;

    // CONSTRUCTOR.
    public ControladorConsultarEncuesta(EntityManager em, PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.em = em;
        this.setPantallaConsultarEncuesta(pantallaConsultarEncuesta); // Dependencia de gestor a pantalla.
    }

    // SINGLETON DE INSTANCIA DE CONTROLADOR.
    public static ControladorConsultarEncuesta getInstancia(EntityManager em,
            PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        if (instance == null) {
            instance = new ControladorConsultarEncuesta(em, pantallaConsultarEncuesta);
        }
        return instance;
    }

    // LÓGICA DE NEGOCIO.

    public void consultarEncuesta() { // Método que acciona el filtro por periódo.
        this.getPantallaConsultarEncuesta().habilitarFiltroPorPeriodo();
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin) { // Método que establece las fechas del periódo para el
                                                                // filtrado de llamadas.
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);

        this.buscarLlamadasConEncuesta(); // Invocación de método para buscar las llamadas con encuesta.
    }

    public IIterator crearIterador(List<Object> elementos) {
        List<Llamada> llamadas = new ArrayList<>();
        // Ahora tienes una lista de objetos que puedes utilizar
        for (Object objeto : elementos) {
            if (objeto instanceof Llamada) {
                Llamada llamada = (Llamada) objeto;
                llamadas.add(llamada);
            }
        }

        IIterator iteradorLlamada = new IteradorLlamada(llamadas, this.getFechaInicio(), this.getFechaFin());
        return iteradorLlamada;
    }

    public void buscarLlamadasConEncuesta() {
        this.getListaLlamadas().clear(); // Vaciar lista de llamadas para no mezclar con contenido previo.
        // Levantar desde BD a memoria todos los objetos de tipo llamada.//
        Persistencia persistencia = new Persistencia(em);
        List<Llamada> llamadas = persistencia.materializarLlamadas();
        // Fin desmaterialización llamadas//

        // Convertir List<Llamada> a List<Object>
        List<Object> elementos = new ArrayList<>();
        for (Llamada llamada : llamadas) {
            elementos.add(llamada);
        }

        IIterator iteradorLlamada = crearIterador(elementos);

        iteradorLlamada.primero();

        do {
            Llamada llamadaActual = (Llamada) iteradorLlamada.actual();
            if (llamadaActual != null) {
                this.getListaLlamadas().add(llamadaActual);
            }
            iteradorLlamada.siguiente();
        } while (!iteradorLlamada.haTerminado());

        this.setListaLlamadas(listaLlamadas); // Establecer valor de la lista de llamadas.
        this.getPantallaConsultarEncuesta().mostrarLlamadasConEncuestaParaSeleccion(); // Solicitar a la pantalla que
                                                                                       // muestre el listado de llamadas
                                                                                       // obtenido.
    }

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada) { // Tomar selección de llamada con encuesta.

        this.getRespuestas().clear(); // Vaciar lista de respuestas para no mezclar con contenido previo.
        this.getPreguntas().clear(); // Vaciar lista de preguntas para no mezclar con contenido previo.

        this.setLlamadaSeleccionada(llamada); // Establecer llamada seleccionada.
        this.obtenerDatosLlamada(); // Invocar método para obtener datos de llamada.
        this.obtenerDatosEncuesta(); // Invocar método para obtener datos de la encuesta correspondiente a la
                                     // llamada.
        this.buscarEncuestaAsociada(); // Buscar la encuesta correspondiente a los datos de encuesta obtenidos.
        this.armarEncuesta(); // Obtener datos restantes de la encuesta para completar su contenido.

        this.getPantallaConsultarEncuesta().mostrarEncuesta(); // Solicitar a la pantalla que muestre la encuesta
                                                               // finalmente formada.
        this.getPantallaConsultarEncuesta().mostrarOpcionesSalida(); // Solicitar a la pantalla que ahbilite las
                                                                     // opciones de salida.

    }

    public void obtenerDatosLlamada() {
        String nombreCliente = this.getLlamadaSeleccionada().getNombreClienteDeLlamada(); // Obtener nombre de cliente.
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
        this.setRespuestas(respuestas); // Establecer atributo de gestor "respuestas".
    }

    public void buscarEncuestaAsociada() {
        String respuesta = this.getRespuestas().get(0); // Toma una respuesta cualquiera, en este caso, la primera.
        String[] partes = respuesta.split("_"); // Divide la cadena a partir del caracter "_".
        String respuestaPosible = partes[1]; // Toma la parte siguiente del caracter "_", la cual representa a una
                                             // respuesta posible y nos permitirá, a través de su instancia, identificar
                                             // la encuesta correspondiente.
        // Levantar desde BD a memoria todos los objetos de tipo Encuesta.//
        Persistencia persistencia = new Persistencia(em);
        List<Encuesta> encuestas = persistencia.materializarEncuestas();
        // Fin desmaterialización encuestas//

        for (Encuesta encuesta : encuestas) { // Recorrer listado de encuestas obtenido.
            Boolean esEncuesta = encuesta.esEncuestaDeCliente(respuestaPosible); // Verificar si es encuesta de cliente,
                                                                                 // a partir del espacio en memoria de
                                                                                 // respuesta posible.
            if (esEncuesta) { // Si es encuesta de cliente.
                this.setEncuestaDeLaLlamada(encuesta); // Establcer atributo de gestor "encuesta".
            }
        }
    }

    public void armarEncuesta() { // Obtengo la información restante para obtener la encuesta completa.

        String descripcionEncuesta = this.getEncuestaDeLaLlamada().getDescripcionEncuesta(); // Obtener descripción de
                                                                                             // encuesta.
        List<String> preguntas = this.getEncuestaDeLaLlamada().getDescripcionPreguntas(); // Obtener preguntas de la
                                                                                          // encuesta.
        // Establecer atributos de gestor "descripcionEncuesta" y "preguntas".
        this.setDescripcionEncuesta(descripcionEncuesta);
        this.setPreguntas(preguntas);
    }

    public void tomarOpcionSalida(String opcion) { // Obtiene la opción de generación de informe.
        switch (opcion) {
            case "CSV": // Si la opción es CSV, invocar método para generar archivo CSV.
                generarCSV();
                break;
            case "Imprimir": // Si la opción es imprimir. invocar método imprimir.
                imprimir();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void generarCSV() { // Método para generar archivo CSV.

        GeneradorCSV generadorCSV = GeneradorCSV.getInstancia();
        generadorCSV.generar(this.getNombreCliente(), this.getUltimoEstadoLlamada(),
                this.getDuracionLlamada(), this.getRespuestas(), this.getPreguntas());
    }

    public void imprimir() { // Método para generar archivo PDF para impresión.
        Impresor impresor = Impresor.getInstancia();
        impresor.imprimir(this.getNombreCliente(), this.getUltimoEstadoLlamada(),
                this.getDuracionLlamada(), this.getRespuestas(), this.getPreguntas());
    }

    public void finCU() {
        System.exit(0); // Finaliza la ejecución del programa sin errores.
    }
}

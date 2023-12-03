package com.mycompany.ivr.Clases.FabricacionPura.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class GeneradorCSV {

    private String nombreCliente;
    private String ultimoEstadoLlamada;
    private String duracionLlamada;
    private List<String> respuestas = new ArrayList<>();
    public List<String> preguntas = new ArrayList<>();

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

    public GeneradorCSV(String nombreCliente, String ultimoEstadoLlamada, String duracionLlamada,
            List<String> respuestas, List<String> preguntas) {
        this.nombreCliente = nombreCliente;
        this.ultimoEstadoLlamada = ultimoEstadoLlamada;
        this.duracionLlamada = duracionLlamada;
        this.respuestas = respuestas;
        this.preguntas = preguntas;
    }

    private static GeneradorCSV generadorCSVInstancia;
    public static GeneradorCSV getInstancia(String nombreCliente, String ultimoEstadoLlamada, String duracionLlamada,
            List<String> respuestas, List<String> preguntas) {
        //SINGLETON
        if (generadorCSVInstancia == null){
            generadorCSVInstancia = new GeneradorCSV(nombreCliente, ultimoEstadoLlamada, duracionLlamada, respuestas, preguntas);
        }
        return generadorCSVInstancia;
    }

    public void generar() {
        
        String csvFile = "C:\\Users\\jlssa\\Documents\\archivo.csv";
        
        try {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = { this.getNombreCliente(), this.getUltimoEstadoLlamada(),
                    this.getDuracionLlamada() };
            csvWriter.writeNext(encabezados);

            ArrayList<String> datos = new ArrayList<>();

            // Escribir celdas de archivo CSV.
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
}

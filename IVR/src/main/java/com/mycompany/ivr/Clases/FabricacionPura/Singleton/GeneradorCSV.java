package com.mycompany.ivr.Clases.FabricacionPura.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class GeneradorCSV {

    private static GeneradorCSV generadorCSVInstancia;

    public static GeneradorCSV getInstancia() {
        // SINGLETON
        if (generadorCSVInstancia == null) {
            generadorCSVInstancia = new GeneradorCSV();
        }
        return generadorCSVInstancia;
    }

    public void generar(String nombreCliente, String ultimoEstadoLlamada, String duracionLlamada,
            List<String> respuestas, List<String> preguntas) {

        //String csvFile = "C:\\Users\\jlssa\\Documents\\archivo.csv";

        String csvFile = "C:\\Users\\JulianSalvucci\\Desktop\\archivo.csv";

        try {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = { nombreCliente, ultimoEstadoLlamada,
                    duracionLlamada };
            csvWriter.writeNext(encabezados);

            ArrayList<String> datos = new ArrayList<>();

            // Escribir celdas de archivo CSV.
            for (int i = 0; i < respuestas.size(); i++) {

                String respuesta = respuestas.get(i);
                String pregunta = preguntas.get(i);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ivr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mycompany.ivr.Clases.Encuesta;
import com.mycompany.ivr.Clases.Llamada;
import com.opencsv.CSVWriter;

/**
 *
 * @author jlssa
 */
public class IVR {

    public static void main(String[] args) {
        System.out.println("¡Hola Mundo!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root); // Obtener llamadas desde base de datos.

        TypedQuery<Llamada> query = em.createQuery(cq);
        List<Llamada> llamadas = query.getResultList();

        System.out.println("LLAMADASSSSSSSSSSSSSSSSS" + llamadas.size());

        Llamada test = llamadas.get(0);

        List<String> respuestas = test.getRespuestas();

        System.out.println("RESPUESTAS" + respuestas);

        String respuesta = respuestas.get(0); // Toma una respuesta cualquiera, en este caso, la primera.
        String[] partes = respuesta.split("_"); // Divide la cadena a partir del caracter "_".
        String respuestaPosible = partes[1];

        System.out.println("POSIBLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + respuestaPosible);

        CriteriaBuilder cb2 = em.getCriteriaBuilder();
        CriteriaQuery<Encuesta> cq2 = cb2.createQuery(Encuesta.class);
        Root<Encuesta> root2 = cq2.from(Encuesta.class);

        cq2.select(root2); // Se levantan en memoria todas las encuestas.

        TypedQuery<Encuesta> query2 = em.createQuery(cq2);
        List<Encuesta> encuestas = query2.getResultList();

        for (Encuesta encuesta : encuestas) { // Recorrer cada encuesta.
            Boolean esEncuesta = encuesta.esEncuestaDeCliente(respuestaPosible); // Verificar si es encuesta de cliente,
                                                                                 // a partir del espacio en memoria de
                                                                                 // respuesta posible.
            if (esEncuesta) { // Si es encuesta de cliente.
                System.out.println("DESCRIPCION" + encuesta.getDescripcionEncuesta());
            } else {
                System.out.println("PREGUNTASSSSSSSS" + encuesta.getPreguntas().size());
            }

        }

        try {
            String csvFile = "C:\\Users\\jlssa\\Documents\\archivo.csv";
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            String[] encabezado = { "Nombre", "Apellido", "Edad" };
            csvWriter.writeNext(encabezado);

            String[] datos1 = { "Juan" };
            csvWriter.writeNext(datos1);

            String[] datos2 = { "María", "Gómez", "25" };
            csvWriter.writeNext(datos2);

            for (int i = 0; i < 3; i++) {
                String[] datos = { "LAL", "Pérez", "30" };
                csvWriter.writeNext(datos);
            }

            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

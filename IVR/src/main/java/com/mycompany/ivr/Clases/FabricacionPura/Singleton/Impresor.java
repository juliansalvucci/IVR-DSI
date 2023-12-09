package com.mycompany.ivr.Clases.FabricacionPura.Singleton;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Desktop;

public class Impresor {
    private static Impresor impresor;

    public static Impresor getInstancia() {
        // SINGLETON
        if (impresor == null) {
            impresor = new Impresor();
        }
        return impresor;
    }

    public void imprimir(String nombreCliente, String ultimoEstadoLlamada, String duracionLlamada,
            List<String> respuestas, List<String> preguntas) {

        String filePath = "C:\\Users\\JulianSalvucci\\Desktop\\archivo.pdf";

        try (PDDocument document = new PDDocument()) {
            // Crear una nueva página en el documento
            PDRectangle pageSize = new PDRectangle(900, 900); // Página personalizada de 1000x500 puntos
            PDPage page = new PDPage(pageSize);

            document.addPage(page);

            // Crear un objeto PDPageContentStream para escribir el contenido en la página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Configurar la fuente y el tamaño del texto
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Escribir texto en la página
            contentStream.beginText();
            float startY = 700; // Posición vertical inicial
            float lineHeight = 15; // Altura de línea

            // Establecer cabecera de PDF.
            contentStream.newLineAtOffset(100, startY);
            contentStream.showText("#################### DATOS DE LLAMADA ####################");
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Cliente: " + nombreCliente);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Estado actual: " + ultimoEstadoLlamada);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Duración: " + duracionLlamada);

            // Establecer detalle con las preguntas y respuestas respectivas.
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("########### DETALLE DE PREGUNTAS Y RESPUESTAS ###########");
            for (int i = 0; i < respuestas.size(); i++) {

                String respuesta = respuestas.get(i);
                String pregunta = preguntas.get(i);
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

        try { // Abrir PDF en pestaña de navegador.
            File file = new File(filePath);
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Desktop;

public class PdfGenerator {
    public static void main(String[] args) {
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
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("¡Hola, mundo!");
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
}

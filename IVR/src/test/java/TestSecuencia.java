import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Controlador.ControladorConsultarEncuesta;
import com.mycompany.ivr.Vista.PantallaConsultarEncuesta;

public class TestSecuencia {
    public static void main(String[] args) {
        System.out.println("¡Hola Secuencia!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        PantallaConsultarEncuesta pantallaConsultarEncuesta = new PantallaConsultarEncuesta();
        ControladorConsultarEncuesta gestor = new ControladorConsultarEncuesta(em, pantallaConsultarEncuesta);

        Boolean habilitar = gestor.consultarEncuesta();

        System.out.println("HABILITACION" + habilitar);

        Scanner scannerFechaInicio = new Scanner(System.in);
        System.out.print("Ingresa una fecha (formato: yyyy-MM-dd): ");
        String fechaInicioIngresada = scannerFechaInicio.nextLine();
        // scannerFechaInicio.close();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = LocalDate.parse(fechaInicioIngresada, formatter);

        Instant instant = fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println("La fecha ingresada es: " + fechaInicio);

        /* FECHA FIN */

        System.out.print("Ingresa una fecha (formato: yyyy-MM-dd): ");

        String fechaFinIngresada = scannerFechaInicio.nextLine();

        DateTimeFormatter formatterFechaFin = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFin = LocalDate.parse(fechaFinIngresada, formatterFechaFin);

        Instant instantFin = fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date dateFin = Date.from(instantFin);
        System.out.println("La fecha ingresada es: " + fechaFin);

        /*
         * LocalDate localDate = LocalDate.of(2021, 6, 3);
         * Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
         * Date date = Date.from(instant);
         * System.out.println(date);
         */

        /*
         * LocalDate localDate1 = LocalDate.of(2023, 10, 3);
         * Instant instant1 =
         * localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant();
         * Date date1 = Date.from(instant1);
         * System.out.println(date1);
         */

        gestor.tomarPeriodo(date, dateFin);

        System.out.println(gestor.getFechaInicio() + "" + gestor.getFechaFin());

        gestor.buscarLlamadasConEncuesta();

        if (gestor.getListaLlamadas().size() > 0) {
            System.out.println("CANTIDAD LLAMADAS ENCONTRADAS" + gestor.getListaLlamadas().size());
        } else {
            System.out.println("NO HAY LLAMADAS EN EL PERIÓDO ESTABLECIDO");
            System.exit(0);
        }

        System.out.print("Ingresa un número: ");
        int numero = scannerFechaInicio.nextInt();

        Llamada llamadaDePrueba = gestor.getListaLlamadas().get(numero);

        scannerFechaInicio.close();

        gestor.tomarSeleccionLlamadaConEncuesta(llamadaDePrueba);

        gestor.obtenerDatosLlamada();

        System.out.println("DATOS LLAMADA" + gestor.getNombreCliente() + gestor.getUltimoEstadoLlamada()
                + gestor.getDuracionLlamada());

        gestor.obtenerDatosEncuesta();

        System.out.println("RESPUESTAS" + " " + gestor.getRespuestas().size());

        gestor.buscarEncuestaAsociada();

        System.out.println("ENCUESTA" + " " + gestor.getEncuesta());

        gestor.armarEncuesta();

        System.out.println("DESCRIPCION ENCUESTA" + " " + gestor.getDescripcionEncuesta());

        System.out.println("PREGUNTAS" + " " + gestor.getPreguntas().size());

        gestor.tomarSalida("PDF");

        gestor.finCU();

    }
}

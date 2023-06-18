import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.ivr.Clases.Llamada;
import com.mycompany.ivr.Controlador.ControladorConsultarEncuesta;

public class TestSecuencia {
    public static void main(String[] args) {
        System.out.println("¡Hola Secuencia!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        ControladorConsultarEncuesta gestor = new ControladorConsultarEncuesta(em);


        LocalDate localDate = LocalDate.of(2022, 6, 3);
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        LocalDate localDate1 = LocalDate.of(2023, 10, 3);
        Instant instant1 = localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date1 = Date.from(instant1);
        System.out.println(date1);

        gestor.tomarPeriodo(date, date1);

        System.out.println(gestor.getFechaInicio() + "" + gestor.getFechaFin());

        gestor.buscarLlamadasConEncuesta();

        System.out.println("CANTIDAD LLAMADAS ENCONTRADAS" + gestor.getListaLlamadas().size());

        Llamada llamadaDePrueba = gestor.getListaLlamadas().get(0);

        gestor.tomarSeleccionLlamadaConEncuesta(llamadaDePrueba);

        gestor.obtenerDatosLlamada();

        System.out.println("DATOS LLAMADA" + gestor.getNombreCliente() + gestor.getUltimoEstadoLlamada() + gestor.getDuracionLlamada());

        gestor.obtenerDatosEncuesta();

        System.out.println("RESPUESTAS" + " " + gestor.getRespuestas().size());

        gestor.buscarEncuestaAsociada();

        System.out.println("ENCUESTA" + " " + gestor.getEncuesta());

        gestor.armarEncuesta();

        System.out.println("DESCRIPCION ENCUESTA" + " " + gestor.getDescripcionEncuesta());

        System.out.println("PREGUNTAS" + " " + gestor.getPreguntas().size());

        gestor.tomarSalida("CSV");

        gestor.finCU();

    }
}

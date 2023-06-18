import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

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


        LocalDate localDate = LocalDate.of(2021, 6, 3);
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

        if(gestor.getListaLlamadas().size() > 0){
            System.out.println("CANTIDAD LLAMADAS ENCONTRADAS" + gestor.getListaLlamadas().size());
        }else{
            System.out.println("NO HAY LLAMADAS EN EL PERIÓDO ESTABLECIDO");
            System.exit(0);
        }
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número: ");
        // Leer el número ingresado por el usuario
        int numero = scanner.nextInt();

        Llamada llamadaDePrueba = gestor.getListaLlamadas().get(numero);

        scanner.close();

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

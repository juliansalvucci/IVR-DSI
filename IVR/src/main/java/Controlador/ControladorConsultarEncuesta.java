/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.Date;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
import Clases.Cliente;
import Clases.Llamada;
import Clases.RespuestaDeCliente;
import Clases.RespuestaPosible;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author jlssa
 */
public class ControladorConsultarEncuesta 
{
    public Date fechaInicio;
    public Date fechaFin;
    public List<Llamada> listaLlamadas;
    public List<RespuestaDeCliente> respuestaDeClientes;
    public List<RespuestaPosible> respuestasPosibles;
    public Llamada llamadaSeleccionada;

    EntityManager em;

    public ControladorConsultarEncuesta(EntityManager em)
    {
        this.em = em;
    }

    public List<Llamada> getListaLlamadas() 
    {
        return listaLlamadas;
    }

    public void tomarPeriodo(Date fechaInicio, Date fechaFin)
    {
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin; 
    }

    public List<Llamada> buscarLlamadasSinEncuesta() 
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root);

        TypedQuery<Llamada> query = em.createQuery(cq);
        var llamadas = query.getResultList();

        for (Llamada llamada : llamadas) 
        {
            if(llamada.esDePeriodo(this.fechaInicio, this.fechaFin))
            {
                llamada.determinarEstadoInicial();
                this.listaLlamadas.add(llamada);
            }   
        }

        return this.listaLlamadas;
    }

    public void obtenerDatosLlamada(){}

    public void tomarSeleccionLlamadaConEncuesta(Llamada llamada)
    {
        this.llamadaSeleccionada = llamada;
    }

    public Cliente buscarDatosClientes()
    {
        return this.llamadaSeleccionada.getCliente();
    }

    

    public List<RespuestaDeCliente> getRTACliente()
    {
        this.respuestaDeClientes = llamadaSeleccionada.getRespuestas();
        return this.respuestaDeClientes;  
    }

    public List<RespuestaPosible> getRespuestasPosibles()
    {
        for(RespuestaDeCliente respuestaDeCliente : this.respuestaDeClientes)
        {
            this.respuestasPosibles.add(respuestaDeCliente.getRespuestaSeleccionada());
        }

        return this.respuestasPosibles;
    }

    public void obtenerDatosEncuestas(Llamada llamada)
    {
        llamada.getRespuestas();
    }

    public void generarCSV()
    {
        String csvFile = "ruta/al/archivo.csv";
        try 
        {
            FileWriter writer = new FileWriter(csvFile);
            CSVWriter csvWriter = new CSVWriter(writer);

            // Escribir los encabezados
            String[] encabezados = {"Nombre", "Apellido", "Edad"};
            csvWriter.writeNext(encabezados);

            // Escribir los datos
            String[] datos1 = {"Juan", "Pérez", "30"};
            csvWriter.writeNext(datos1);

            String[] datos2 = {"María", "Gómez", "25"};
            csvWriter.writeNext(datos2);

            csvWriter.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void finCU()
    {
        System.exit(0); //Finaliza la ejecución del programa sin errores. 
    }
}

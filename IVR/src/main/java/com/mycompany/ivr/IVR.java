/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.ivr;
import com.mycompany.ivr.Controlador.ControladorPantallaPrincipal;

/**
 *
 * @author jlssa
 */
public class IVR {
    public static void main(String[] args) {
        System.out.println("¡Hola Mundo!");
        //Crear instanacia de PantallaPrincipal al ejecutar
        ControladorPantallaPrincipal gestorPantalla = ControladorPantallaPrincipal.getInstancia();
        gestorPantalla.mostrarPantallaPrincipal();
    }
}

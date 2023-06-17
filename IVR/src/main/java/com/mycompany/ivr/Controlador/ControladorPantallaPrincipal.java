/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Controlador;
import com.mycompany.ivr.Vista.PantallaPrincipal;

/**
 *
 * @author Julian
 */
public class ControladorPantallaPrincipal {
    private static ControladorPantallaPrincipal instanciaUnica; 
    public static ControladorPantallaPrincipal getInstancia(){
        //SINGLETON
        if (instanciaUnica == null){
            instanciaUnica = new ControladorPantallaPrincipal();
        }
        return instanciaUnica;
    }
    
    public void mostrarPantallaPrincipal(){
        PantallaPrincipal pantalla = new PantallaPrincipal(this);
        pantalla.setVisible(true);
    }
}
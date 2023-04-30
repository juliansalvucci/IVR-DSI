/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jlssa
 */
public class Cliente 
{
    private String dni;
    private String nombreCompleto;
    private String nroCelular;
    
    public String getDni() 
    {
        return dni;
    }

    public void setDni(String dni) 
    {
        this.dni = dni;
    }

    public String getNombreCompleto() 
    {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) 
    {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) 
    {
        this.nroCelular = nroCelular;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ivr.Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jlssa
 */

@Entity
@Table(name = "cliente")
public class Cliente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public String getNroCelular() 
    {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) 
    {
        this.nroCelular = nroCelular;
    }
}

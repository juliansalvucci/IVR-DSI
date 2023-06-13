/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 *
 * @author jlssa
 */
@Entity
@Table (name="estado", indexes = {
    @Index(columnList = "id",name = "idx"),
})
public class Estado 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;    

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


/**
 *
 * @author Bautista
 */

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 50)
    private String persNombre;
    @Size(min = 1, max = 50)
    private String persApellido;
    @Size(min = 1, max = 50)
    private String persLocalidad;
    @Size(min = 1, max = 50)
    private String persTitulo;
    @Size(min = 1, max = 600)
    private String persAbout;
    @Size(min = 1, max = 2000)
    private String persImg;

    public Person(){
    
    }
    
    public Person(String persNombre, String persApellido, String persLocalidad, String persTitulo, String persAbout, String persImg) {
        this.persNombre = persNombre;
        this.persApellido = persApellido;
        this.persLocalidad = persLocalidad;
        this.persTitulo = persTitulo;
        this.persAbout = persAbout;
        this.persImg = persImg;
    }
    
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
        
    }

    public String getPersNombre() {
        return persNombre;
        
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
        
    }

    public String getPersApellido() {
        return persApellido;
        
    }

    public void setPersApellido(String persApellido) {
        this.persApellido = persApellido;
        
    }
    
    public String getPersLocalidad() {
       return persLocalidad;
        
    }

    public void setPersLocalidad(String persLocalidad) {
       this.persLocalidad = persLocalidad;
        
    }
    
        public String getPersTitulo() {
        return persTitulo;
        
    }

    public void setPersTitulo(String persTitulo) {
        this.persTitulo = persTitulo;
        
    }
    
    public String getPersAbout() {
        return persAbout;
        
    }

    public void setPersAbout(String persAbout) {
        this.persAbout = persAbout;
        
    }
    
    public String getPersImg() {
        return persImg;
        
    }

    public void setPersImg(String persImg) {
        this.persImg = persImg;
    
    
    }
    
}

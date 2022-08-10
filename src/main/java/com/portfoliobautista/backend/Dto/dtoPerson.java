/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bautista
 */

public class dtoPerson {

    @NotBlank
    private String persNombre;
    @NotBlank
    private String persApellido;
    @NotBlank
    private String persLocalidad;
    @NotBlank
    private String persTitulo;
    @NotBlank
    private String persAbout;
    @NotBlank
    private String persImg;
    
    //constructors
    public dtoPerson() {
        
    }

    public dtoPerson(String persNombre, String persApellido, String persLocalidad, String persTitulo, String persAbout, String persImg) {
        this.persNombre = persNombre;
        this.persApellido = persApellido;
        this.persLocalidad = persLocalidad;
        this.persTitulo = persTitulo;
        this.persTitulo = persAbout;
        this.persTitulo = persImg;
        
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Bautista
 */
public class dtoExperience {
    @NotBlank
    private String expName;
    @NotBlank
    private String expDesc;
    @NotBlank
    private String expTime;
    @NotBlank
    private String expImg;
    
    //constructors
    public dtoExperience() {
        
    }

    public dtoExperience(String expName, String expDesc, String expTime, String expImg) {
        this.expName = expName;
        this.expDesc = expDesc;
        this.expTime = expTime;
        this.expImg = expImg;
        
    }
    
    
    //getters setters

    public String getExpName() {
        return expName;
        
    }

    public void setExpName(String expName) {
        this.expName = expName;
        
    }

    public String getExpDesc() {
        return expDesc;
        
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
        
    }
    
    public String getExpTime() {
        return expTime;
        
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
        
    }
    
        public String getExpImg() {
        return expImg;
        
    }

    public void setExpImg(String expImg) {
        this.expImg = expImg;
        
    }
    
}

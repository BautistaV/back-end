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
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 60)
    private String expName;
    @Size(min = 1, max = 600)
    private String expDesc;
    @Size(min = 1, max = 20)
    private String expTime;
    @Size(min = 1, max = 1000)
    private String expImg;
    
    
    public Experience() {
        
    }

    public Experience(String expName, String expDesc, String expTime, String expImg) {
        this.expName = expName;
        this.expDesc = expDesc;
        this.expTime = expTime;
        this.expImg = expImg;
        
    }

    
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
        
    }

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

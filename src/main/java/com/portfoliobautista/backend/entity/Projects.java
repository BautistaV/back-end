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
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projName;
    @Size(min = 1, max = 1000)
    private String projDesc;
    private String projTime;
    private String projImg;
    private String projLink;
    
    
    public Projects() {
        
    }

    public Projects(String projName, String projDesc, String projTime, String projImg, String projLink) {
        this.projName = projName;
        this.projDesc = projDesc;
        this.projTime = projTime;
        this.projImg = projImg;
        this.projLink = projLink;
        
    }

    
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
        
    }

    public String getProjName() {
        return projName;
        
    }

    public void setProjName(String projName) {
        this.projName = projName;
        
    }

    public String getProjDesc() {
        return projDesc;
        
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
        
    }
    
    public String getProjTime() {
       return projTime;
        
    }

    public void setProjTime(String projTime) {
       this.projTime = projTime;
        
    }
    
    public String getProjImg() {
        return projImg;
        
    }

    public void setProjImg(String projImg) {
        this.projImg = projImg;
        
    }
    
    public String getProjLink() {
        return projLink;
        
    }

    public void setProjLink(String projLink) {
        this.projLink = projLink;
        
    }
    
}

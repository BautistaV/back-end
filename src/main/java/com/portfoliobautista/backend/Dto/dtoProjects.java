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
public class dtoProjects {
     @NotBlank
    private String projName;
    @NotBlank
    private String projDesc;
    @NotBlank
    private String projTime;
    @NotBlank
    private String projImg;
    
    //constructors
    public dtoProjects() {
        
    }

    public dtoProjects(String projName, String projDesc, String projTime, String projImg) {
        this.projName = projName;
        this.projDesc = projDesc;
        this.projTime = projTime;
        this.projImg = projImg;
        
    }
    
    
    //getters setters

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
}

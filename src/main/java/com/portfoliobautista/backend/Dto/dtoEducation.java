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
public class dtoEducation {
    @NotBlank
    private String eduName;
    @NotBlank
    private String eduDesc;
    @NotBlank
    private String eduTime;
    @NotBlank
    private String eduImg;
    
    //constructors
    public dtoEducation() {
        
    }

    public dtoEducation(String eduName, String eduDesc, String eduTime, String eduImg) {
        this.eduName = eduName;
        this.eduDesc = eduDesc;
        this.eduTime = eduTime;
        this.eduImg = eduImg;
        
    }
    
    
    //getters setters

    public String getEduName() {
        return eduName;
        
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
        
    }

    public String getEduDesc() {
        return eduDesc;
        
    }

    public void setEduDesc(String eduDesc) {
        this.eduDesc = eduDesc;
        
    }
    
    public String getEduTime() {
        return eduTime;
        
    }

    public void setEduTime(String eduTime) {
        this.eduTime = eduTime;
        
    }
    
        public String getEduImg() {
        return eduImg;
        
    }

    public void setEduImg(String eduImg) {
        this.eduImg = eduImg;
        
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bautista
 */
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eduName;
    private String eduDesc;
    private String eduTime;
    private String eduImg;
    
    
    public Education() {
        
    }

    public Education(String eduName, String eduDesc, String eduTime, String eduImg) {
        this.eduName = eduName;
        this.eduDesc = eduDesc;
        this.eduTime = eduTime;
        this.eduImg = eduImg;
        
    }

    
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
        
    }

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

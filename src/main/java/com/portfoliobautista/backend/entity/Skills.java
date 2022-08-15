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
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 60)
    private String skillName;
    @Size(min = 1, max = 3)
    private String skillPercent;
    
    
    public Skills() {
        
    }

    public Skills(String skillName, String skillPercent) {
        this.skillName = skillName;
        this.skillPercent = skillPercent;
    }

    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
        
    }

    public String getSkillName() {
        return skillName;
        
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
        
    }

    public String getSkillPercent() {
        return skillPercent;
        
    }

    public void setSkillPercent(String skillPercent) {
        this.skillPercent = skillPercent;
        
    }
    
}

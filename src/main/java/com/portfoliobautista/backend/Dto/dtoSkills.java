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
public class dtoSkills {
    
    @NotBlank
    private String skillName;
    @NotBlank
    private String skillPercent;
    
    //constructors
    public dtoSkills() {
        
    }

    public dtoSkills(String skillName, String skillPercent) {
        this.skillName = skillName;
        this.skillPercent = skillPercent;
    }
    
    //getters setters

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

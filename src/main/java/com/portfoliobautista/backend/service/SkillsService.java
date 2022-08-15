/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.service;

import com.portfoliobautista.backend.entity.Skills;
import com.portfoliobautista.backend.repository.RSkills;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bautista
 */
@Service
@Transactional
public class SkillsService {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list() {
        return rSkills.findAll();
        
    }

    public Optional<Skills> getOne(int id) {
        return rSkills.findById(id);
        
    }

    public Optional<Skills> getBySkillName(String skillName) {
        return rSkills.findBySkillName(skillName);
        
    }

    public void save(Skills proj) {
        rSkills.save(proj);
        
    }

    public void delete(int id) {
        rSkills.deleteById(id);
        
    }

    public boolean existsById(int id) {
        return rSkills.existsById(id);
        
    }

    public boolean existsBySkillName(String skillName) {
        return rSkills.existsBySkillName(skillName);
        
    }
    
}

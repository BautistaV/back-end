/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.service;

import com.portfoliobautista.backend.entity.Experience;
import com.portfoliobautista.backend.repository.RExperience;
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
public class ExperienceService {

    @Autowired
    RExperience rExp;

    public List<Experience> list() {
        return rExp.findAll();
        
    }

    public Optional<Experience> getOne(int id) {
        return rExp.findById(id);
        
    }

    public Optional<Experience> getByExpName(String expName) {
        return rExp.findByExpName(expName);
        
    }

    public void save(Experience exp) {
        rExp.save(exp);
        
    }

    public void delete(int id) {
        rExp.deleteById(id);
        
    }

    public boolean existsById(int id) {
        return rExp.existsById(id);
        
    }

    public boolean existsByExpName(String expName) {
        return rExp.existsByExpName(expName);
        
    }
}
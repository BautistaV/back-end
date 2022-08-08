/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.service;

import com.portfoliobautista.backend.entity.Education;
import com.portfoliobautista.backend.repository.REducation;
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
public class EducationService {
    
    @Autowired
    REducation rEdu;

    public List<Education> list() {
        return rEdu.findAll();
        
    }

    public Optional<Education> getOne(int id) {
        return rEdu.findById(id);
        
    }

    public Optional<Education> getByEduName(String eduName) {
        return rEdu.findByEduName(eduName);
        
    }

    public void save(Education edu) {
        rEdu.save(edu);
        
    }

    public void delete(int id) {
        rEdu.deleteById(id);
        
    }

    public boolean existsById(int id) {
        return rEdu.existsById(id);
        
    }

    public boolean existsByEduName(String eduName) {
        return rEdu.existsByEduName(eduName);
        
    }

}

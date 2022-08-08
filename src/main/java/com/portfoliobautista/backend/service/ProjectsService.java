/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.service;

import com.portfoliobautista.backend.entity.Projects;
import com.portfoliobautista.backend.repository.RProjects;
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
public class ProjectsService {
    @Autowired
    RProjects rProj;

    public List<Projects> list() {
        return rProj.findAll();
        
    }

    public Optional<Projects> getOne(int id) {
        return rProj.findById(id);
        
    }

    public Optional<Projects> getByProjName(String projName) {
        return rProj.findByProjName(projName);
        
    }

    public void save(Projects proj) {
        rProj.save(proj);
        
    }

    public void delete(int id) {
        rProj.deleteById(id);
        
    }

    public boolean existsById(int id) {
        return rProj.existsById(id);
        
    }

    public boolean existsByProjName(String projName) {
        return rProj.existsByProjName(projName);
        
    }
    
}

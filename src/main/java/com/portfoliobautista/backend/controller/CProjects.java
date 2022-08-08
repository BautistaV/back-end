/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Dto.dtoProjects;
import com.portfoliobautista.backend.entity.Projects;
import com.portfoliobautista.backend.security.controller.Mensaje;
import com.portfoliobautista.backend.service.ProjectsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bautista
 */
@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class CProjects {
    @Autowired
    ProjectsService projService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Projects>> list(){
        List<Projects> list = projService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id){
        if(!projService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Projects projects = projService.getOne(id).get();
        return new ResponseEntity(projects, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!projService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        projService.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
        
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjects dtoproj){      
        if(StringUtils.isBlank(dtoproj.getProjName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(projService.existsByProjName(dtoproj.getProjName()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Projects projects = new Projects(dtoproj.getProjName(), dtoproj.getProjDesc(), dtoproj.getProjTime(), dtoproj.getProjImg());
        projService.save(projects);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjects dtoproj){

        if(!projService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(projService.existsByProjName(dtoproj.getProjName()) && projService.getByProjName(dtoproj.getProjName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoproj.getProjName()))
            return new ResponseEntity(new Mensaje("Falta el nombre del proyecto"), HttpStatus.BAD_REQUEST);
        
        Projects projects = projService.getOne(id).get();
        projects.setProjName(dtoproj.getProjName());
        projects.setProjDesc((dtoproj.getProjDesc()));
        projects.setProjTime((dtoproj.getProjTime()));
        projects.setProjTime((dtoproj.getProjImg()));
        
        projService.save(projects);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
             
    }
 
}

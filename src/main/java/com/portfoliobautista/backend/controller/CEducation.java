/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Dto.dtoEducation;
import com.portfoliobautista.backend.entity.Education;
import com.portfoliobautista.backend.security.controller.Mensaje;
import com.portfoliobautista.backend.service.EducationService;
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
@RequestMapping("/eduexp")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducation {
    
    @Autowired
    EducationService eduService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education education = eduService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);
        
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoedu){      
        if(StringUtils.isBlank(dtoedu.getEduName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(eduService.existsByEduName(dtoedu.getEduName()))
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        
        Education education = new Education(dtoedu.getEduName(), dtoedu.getEduDesc(), dtoedu.getEduTime(), dtoedu.getEduImg());
        eduService.save(education);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoedu){

        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(eduService.existsByEduName(dtoedu.getEduName()) && eduService.getByEduName(dtoedu.getEduName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoedu.getEduName()))
            return new ResponseEntity(new Mensaje("Falta el nombre de la educacion"), HttpStatus.BAD_REQUEST);
        
        Education education = eduService.getOne(id).get();
        education.setEduName(dtoedu.getEduName());
        education.setEduDesc((dtoedu.getEduDesc()));
        education.setEduTime((dtoedu.getEduTime()));
        education.setEduImg((dtoedu.getEduImg()));
        
        eduService.save(education);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
 
}

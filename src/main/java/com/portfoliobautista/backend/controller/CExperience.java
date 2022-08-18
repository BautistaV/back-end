/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Dto.dtoExperience;
import com.portfoliobautista.backend.entity.Experience;
import com.portfoliobautista.backend.security.controller.Mensaje;
import com.portfoliobautista.backend.service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/workexp")
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliobautista-f146c.web.app")


public class CExperience {
    
    @Autowired
    ExperienceService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experience = expService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        expService.delete(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);
        
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp){      
        if(StringUtils.isBlank(dtoexp.getExpName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existsByExpName(dtoexp.getExpName()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience = new Experience(dtoexp.getExpName(), dtoexp.getExpDesc(), dtoexp.getExpTime(), dtoexp.getExpImg());
        expService.save(experience);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperience dtoexp){

        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(expService.existsByExpName(dtoexp.getExpName()) && expService.getByExpName(dtoexp.getExpName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoexp.getExpName()))
            return new ResponseEntity(new Mensaje("Falta el nombre de la experiencia"), HttpStatus.BAD_REQUEST);
        
        Experience experience = expService.getOne(id).get();
        experience.setExpName(dtoexp.getExpName());
        experience.setExpDesc(dtoexp.getExpDesc());
        experience.setExpTime(dtoexp.getExpTime());
        experience.setExpImg(dtoexp.getExpImg());
        
        expService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
 
}

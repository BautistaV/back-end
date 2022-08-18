/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Dto.dtoSkills;
import com.portfoliobautista.backend.entity.Skills;
import com.portfoliobautista.backend.security.controller.Mensaje;
import com.portfoliobautista.backend.service.SkillsService;
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
@RequestMapping("/skills")
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliobautista-f146c.web.app")

public class CSkills {
    
    @Autowired
    SkillsService skillsService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
        
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){      
        if(StringUtils.isBlank(dtoskills.getSkillName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsBySkillName(dtoskills.getSkillName()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoskills.getSkillName(), dtoskills.getSkillPercent());
        skillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){

        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(skillsService.existsBySkillName(dtoskills.getSkillName()) && skillsService.getBySkillName(dtoskills.getSkillName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoskills.getSkillName()))
            return new ResponseEntity(new Mensaje("Falta el nombre de la habilidad"), HttpStatus.BAD_REQUEST);
        
        Skills skills = skillsService.getOne(id).get();
        skills.setSkillName(dtoskills.getSkillName());
        skills.setSkillPercent(dtoskills.getSkillPercent());
        
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
 
    
}

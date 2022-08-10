/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Dto.dtoPerson;
import com.portfoliobautista.backend.entity.Person;
import com.portfoliobautista.backend.security.controller.Mensaje;
import com.portfoliobautista.backend.service.PersonService;
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
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200")
public class CPerson {
    
    @Autowired
    PersonService persService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list(){
        List<Person> list = persService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!persService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Person person = persService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!persService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        persService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
        
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerson dtopers){      
        if(StringUtils.isBlank(dtopers.getPersNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      //  if(persService.existsByPersNombre(dtopers.getPersNombre()))
       //     return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Person person = new Person(dtopers.getPersNombre(), dtopers.getPersApellido(), dtopers.getPersLocalidad(), dtopers.getPersTitulo(), dtopers.getPersAbout(), dtopers.getPersImg());
        persService.save(person);
        
        return new ResponseEntity(new Mensaje("persona agregada"), HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerson dtopers){

        if(!persService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

     //   if(persService.existsByPersName(dtopers.getPersName()) && persService.getByPersName(dtopers.getPersName()).get().getId() != id)
     //       return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

     //   if(StringUtils.isBlank(dtopers.getPersNombre()))
       //     return new ResponseEntity(new Mensaje("Falta el nombre"), HttpStatus.BAD_REQUEST);
      //  if(StringUtils.isBlank(dtopers.getPersApellido()))
        //    return new ResponseEntity(new Mensaje("Falta el nombre"), HttpStatus.BAD_REQUEST);
        
        Person person = persService.getOne(id).get();
        person.setPersNombre(dtopers.getPersNombre());
        person.setPersApellido(dtopers.getPersApellido());
        person.setPersLocalidad(dtopers.getPersLocalidad());
        person.setPersTitulo(dtopers.getPersTitulo());
        person.setPersAbout(dtopers.getPersAbout());
        person.setPersImg(dtopers.getPersImg());
        
        persService.save(person);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
             
    }
 
}

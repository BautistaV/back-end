/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.service;

import com.portfoliobautista.backend.entity.Person;
import com.portfoliobautista.backend.repository.RPerson;
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
public class PersonService {
    
    @Autowired
    RPerson rPer;

    public List<Person> list() {
        return rPer.findAll();
        
    }

    public Optional<Person> getOne(int id) {
        return rPer.findById(id);
        
    }

    public Optional<Person> getByPersNombre(String persNombre) {
        return rPer.findByPersNombre(persNombre);
        
    }

    public void save(Person pers) {
        rPer.save(pers);
        
    }

    public void delete(int id) {
        rPer.deleteById(id);
        
    }

    public boolean existsById(int id) {
        return rPer.existsById(id);
        
    }

    public boolean existsByPersNombre(String persNombre) {
        return rPer.existsByPersNombre(persNombre);
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliobautista.backend.repository;

import com.portfoliobautista.backend.entity.Experience;
import com.portfoliobautista.backend.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bautista
 */
@Repository
public interface RPerson extends JpaRepository<Person, Integer>{
    

    public Optional<Person> findByPersNombre(String persNombre);
    public boolean existsByPersNombre(String persNombre);
}

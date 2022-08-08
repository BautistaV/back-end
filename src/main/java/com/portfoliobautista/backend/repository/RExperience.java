/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliobautista.backend.repository;


import com.portfoliobautista.backend.entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bautista
 */
@Repository
public interface RExperience extends JpaRepository<Experience, Integer>{

    public Optional<Experience> findByExpName(String expName);
    public boolean existsByExpName(String expName);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.repository;


import com.portfoliobautista.backend.entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bautista
 */
@Repository
public interface REducation extends JpaRepository<Education, Integer>{

    public Optional<Education> findByEduName(String expName);
    public boolean existsByEduName(String expName);
    
}

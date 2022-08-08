/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backend.repository;

import com.portfoliobautista.backend.entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bautista
 */
@Repository
public interface RProjects extends JpaRepository<Projects, Integer>{

    public Optional<Projects> findByProjName(String projName);
    public boolean existsByProjName(String projName);
    
}

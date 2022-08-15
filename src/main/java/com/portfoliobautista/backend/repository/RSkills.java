/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliobautista.backend.repository;

import com.portfoliobautista.backend.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bautista
 */
@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{

    public Optional<Skills> findBySkillName(String skillName);
    public boolean existsBySkillName(String skillName);
    
}

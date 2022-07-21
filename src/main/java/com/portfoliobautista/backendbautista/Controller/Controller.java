/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobautista.backendbautista.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bautista
 */

@RestController
public class Controller {
    
    @GetMapping ("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre){
        return "Hola mundo " + nombre;
    }
    
}

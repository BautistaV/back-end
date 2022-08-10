package com.portfoliobautista.backend.controller;

import com.portfoliobautista.backend.Interface.IPersonaService;
import com.portfoliobautista.backend.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personas")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return ("La persona fue creada correctamente");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img_perfil") String nuevoImg_perfil,
                                @RequestParam("about") String nuevoAbout,
                                @RequestParam("location") String nuevoLocation,
                                @RequestParam("titulo") String nuevoTitulo)
    {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg_perfil(nuevoImg_perfil);
        persona.setAbout(nuevoAbout);
        persona.setLocation(nuevoLocation);
        persona.setTitulo(nuevoTitulo);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
}

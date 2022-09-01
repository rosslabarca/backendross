/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.Controller;

import com.Proyecto_Integrador_AP.SpringBoot.Dto.dtoPersona;
import com.Proyecto_Integrador_AP.SpringBoot.Security.Controller.Mensaje;
import com.Proyecto_Integrador_AP.SpringBoot.entity.Persona;
import com.Proyecto_Integrador_AP.SpringBoot.service.SPersona;
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

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://rossfrontend.web.app")
public class CPersona {
    
     @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
    if(!sPersona.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
    }
    Persona persona = sPersona.getOne(id).get();
    return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
           return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sPersona.existsByNombre(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(
        dtopersona.getNombre(), dtopersona.getProfesion(), dtopersona.getLocacion(), dtopersona.getImgProfile(), dtopersona.getAcercaDe());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
    if(!sPersona.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    }
    if(sPersona.existsByNombre(dtopersona.getNombre())&&sPersona.getByNombre(dtopersona.getNombre()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isBlank(dtopersona.getNombre())){
           return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
    }
    
    Persona persona = sPersona.getOne(id).get();
    
    persona.setNombre(dtopersona.getNombre());
    persona.setProfesion(dtopersona.getProfesion());
    persona.setLocacion(dtopersona.getLocacion());
    persona.setImgProfile(dtopersona.getImgProfile());
    persona.setAcercaDe(dtopersona.getAcercaDe());
    
    
    sPersona.save(persona);
    
    return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}

    
        


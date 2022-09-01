/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.Controller;

import com.Proyecto_Integrador_AP.SpringBoot.Dto.dtoSkills;
import com.Proyecto_Integrador_AP.SpringBoot.Security.Controller.Mensaje;
import com.Proyecto_Integrador_AP.SpringBoot.entity.Skills;
import com.Proyecto_Integrador_AP.SpringBoot.service.SSkills;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://rossfrontend.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
            return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);        
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skills eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombreSkills())){
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombreSkills(dtoskills.getNombreSkills())){
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = new Skills(dtoskills.getNombreSkills(), dtoskills.getPorcentaje());
        
        sSkills.save(skills);
            return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sSkills.existsByNombreSkills(dtoskills.getNombreSkills())&& sSkills.getByNombreSkills(dtoskills.getNombreSkills()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Skills existente"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = sSkills.getOne(id).get();
        
        skills.setNombreSkills(dtoskills.getNombreSkills());
        skills.setPorcentaje(dtoskills.getPorcentaje());
        
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);
    }
}

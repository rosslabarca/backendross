/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.Controller;

import com.Proyecto_Integrador_AP.SpringBoot.Dto.dtoExperiencia;
import com.Proyecto_Integrador_AP.SpringBoot.Security.Controller.Mensaje;
import com.Proyecto_Integrador_AP.SpringBoot.entity.Experiencia;
import com.Proyecto_Integrador_AP.SpringBoot.service.SExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://rossfrontend.web.app")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
            return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
    if(!sExperiencia.existsById(id)){
        return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    }
    Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sExperiencia.existsById(id)){
         return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
    sExperiencia.delete(id);
    return new ResponseEntity(new Mensaje("campo eliminado"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sExperiencia.existsByNombreE(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getFechaIni(), dtoexp.getFechaFin(), dtoexp.getImagenE(), dtoexp.getUrlE());
        sExperiencia.save(experiencia);
        
            return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sExperiencia.existsByNombreE(dtoexp.getNombreE())&&sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje ("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setFechaIni(dtoexp.getFechaIni());
        experiencia.setFechaFin(dtoexp.getFechaFin());
        experiencia.setImagenE(dtoexp.getImagenE());
        experiencia.setUrlE(dtoexp.getUrlE());
        
           
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}

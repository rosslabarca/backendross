/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.repository;

import com.Proyecto_Integrador_AP.SpringBoot.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombreSkills(String nombreSkills);
    public boolean existsByNombreSkills(String nombreSkills);
}

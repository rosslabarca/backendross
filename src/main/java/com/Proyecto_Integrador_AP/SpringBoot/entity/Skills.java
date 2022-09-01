/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreSkills;
    private int porcentaje;

    public Skills() {
    }

    public Skills(String nombreSkills, int porcentaje) {
        this.nombreSkills = nombreSkills;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkills() {
        return nombreSkills;
    }

    public void setNombreSkills(String nombreSkills) {
        this.nombreSkills = nombreSkills;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}

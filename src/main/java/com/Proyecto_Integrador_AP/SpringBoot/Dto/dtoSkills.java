/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Standard
 */
public class dtoSkills {
    
    @NotBlank
    private String nombreSkills;
    
    @NotBlank
    private int porcentaje;

    public dtoSkills() {
    }

    public dtoSkills(String nombreSkills, int porcentaje) {
        this.nombreSkills = nombreSkills;
        this.porcentaje = porcentaje;
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

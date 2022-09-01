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
public class dtoPersona {
   @NotBlank
    private String nombre;
   
   @NotBlank
    private String profesion;
   
   @NotBlank
    private String locacion;
   
   @NotBlank
    private String imgProfile;
   
   @NotBlank
    private String acercaDe;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String profesion, String locacion, String imgProfile, String acercaDe) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.locacion = locacion;
        this.imgProfile = imgProfile;
        this.acercaDe = acercaDe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

}

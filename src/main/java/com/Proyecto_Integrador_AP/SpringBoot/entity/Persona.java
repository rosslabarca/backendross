/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
  
   private int id;
    private String nombre;
    private String profesion;
    private String locacion;
    private String imgProfile;
    private String acercaDe;

    public Persona() {
    }

    public Persona(String nombre, String profesion, String locacion, String imgProfile, String acercaDe) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.locacion = locacion;
        this.imgProfile = imgProfile;
        this.acercaDe = acercaDe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

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
public class dtoProyectos {
   
    @NotBlank
    private String nombreP;
    
    @NotBlank
    private String descripcionP;
    
    @NotBlank
    private String imagenP;
    
    @NotBlank
    private String url;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String imagenP, String url) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
        this.url = url;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.Dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Standard
 */
public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaIni;
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaFin;
    
    @NotBlank
    private String imagenE;
    
    @NotBlank
    private String urlE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, Date fechaIni, Date fechaFin, String imagenE, String urlE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.imagenE = imagenE;
        this.urlE = urlE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImagenE() {
        return imagenE;
    }

    public void setImagenE(String imagenE) {
        this.imagenE = imagenE;
    }

    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }

}

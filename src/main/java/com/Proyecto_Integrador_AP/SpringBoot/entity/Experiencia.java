/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Integrador_AP.SpringBoot.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaIni;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaFin;
    
    private String imagenE;
    
    private String urlE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, Date fechaIni, Date fechaFin, String imagenE, String urlE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.imagenE = imagenE;
        this.urlE = urlE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

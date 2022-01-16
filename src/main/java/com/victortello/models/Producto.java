package com.victortello.models;

import java.util.Date;

public class Producto {

    private Long id;
    private String cnombre;
    private int precio;
    private Date dFechaRegistro;


    
    public Producto() {
    }

    public Producto(Long id, String cnombre, int precio, Date dFechaRegistro) {
        this.id = id;
        this.cnombre = cnombre;
        this.precio = precio;
        this.dFechaRegistro = dFechaRegistro;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCnombre() {
        return cnombre;
    }
    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Date getdFechaRegistro() {
        return dFechaRegistro;
    }
    public void setdFechaRegistro(Date dFechaRegistro) {
        this.dFechaRegistro = dFechaRegistro;
    }

    
    
}

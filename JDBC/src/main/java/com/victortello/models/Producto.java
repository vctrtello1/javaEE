package com.victortello.models;

import java.util.Date;

public class Producto {

    private Long id;
    private String cnombre;
    private int iprecio;
    private Date dFechaRegistro;
    private Categoria categoria;
  
    public Producto() {
    }

    public Producto(Long id, String cnombre, int iprecio, Date dFechaRegistro, Categoria categoria) {
        this.id = id;
        this.cnombre = cnombre;
        this.iprecio = iprecio;
        this.dFechaRegistro = dFechaRegistro;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto [cnombre=" + cnombre + ", dFechaRegistro=" + dFechaRegistro + ", id=" + id + ", iprecio="
                + iprecio + "] "  + categoria.getCnombre();
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
    
    public int getIprecio() {
        return iprecio;
    }

    public void setIprecio(int iprecio) {
        this.iprecio = iprecio;
    }

    public Date getdFechaRegistro() {
        return dFechaRegistro;
    }
    public void setdFechaRegistro(Date dFechaRegistro) {
        this.dFechaRegistro = dFechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }  
    
}

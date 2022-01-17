package com.victortello.models;

public class Categoria {

    private Long id;
    private String cnombre;

    public Categoria() {
    }

    public Categoria(Long id, String cnombre) {
        this.id = id;
        this.cnombre = cnombre;
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

    
}


package com.emergentes.modelo;

import java.util.Date;

public class Universitario {
    private int id;
    private String nombre;
    private String apellido;
    private String categoria;
    private int confirmado;
    private String fecha1;
   

    public Universitario() {
        this.id =0;
        this.nombre="";
        this.apellido="";
        this.categoria="";
        this.confirmado=0;
        this.fecha1="";
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }    
}

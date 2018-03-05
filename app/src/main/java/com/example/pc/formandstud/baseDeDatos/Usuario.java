package com.example.pc.formandstud.baseDeDatos;

/**
 * Created by oriol on 05/03/2018.
 */

public class Usuario {

    private Integer id;
    private String Nombre;
    private String telefono;

    public Usuario(Integer id, String nombre, String telefono) {
        this.id = id;
        Nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

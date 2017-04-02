package com.example.camilo.inicio.modelos;

import java.util.List;

/**
 * Created by CAMILO on 29/03/2017.
 */

public class Contacto {

    public int id;
    public String nombre;
    public String telefono;
    public List<Contacto> contactos;



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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }


}

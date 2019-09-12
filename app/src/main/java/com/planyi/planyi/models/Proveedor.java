package com.planyi.planyi.models;

import java.util.List;

public class Proveedor {

    private int proveedorId;
    private String nombre;
    private int precio;

    public Proveedor(int id, String nombre, int precio) {
        proveedorId = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getProveedorId() {
        return proveedorId;
    }
}

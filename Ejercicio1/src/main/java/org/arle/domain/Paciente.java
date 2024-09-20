package org.arle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private List<Direccion> direcciones;
    private String apellido;
    private int edad;
    private int telefono;
    private String genero;

    public Paciente(String nombre, String apellido, int edad, int telefono, String genero) {
        this.nombre = nombre;
        this.direcciones = new ArrayList<>();
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void addDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    @Override
    public String toString() {
        return "Paciente:\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Telefono: " + telefono + "\n" +
                "Direcciones: " + direcciones + "\n" +
                "Genero: " + genero + "\n";
    }
}
package org.cuervo.Dominio;

import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String apellido;
    private String edad;
    private String cargo;
    private String departamento;
    private int salario;


    public Empleado() {}



    public Empleado(int id, String nombre, String apellido, String edad, String cargo, String departamento, int salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.id = id;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Empleado: \n" +
                "ID: " + id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Edad: " + edad + '\n' +
                "Cargo: " + cargo + '\n' +
                "Departamento: " + departamento + '\n' +
                "Salario: " + salario + "\n";
    }
}

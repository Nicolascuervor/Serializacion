package org.cuervo.Dominio;

import java.io.Serializable;

public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idTarea;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    Empleado empleado;



    public Tarea() {}

    public Tarea(int idTarea,String titulo, String descripcion, String fechaInicio, String fechaFin, String estado, Empleado empleado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.empleado = empleado;
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    @Override
    public String toString() {
        return "Tarea:\n" +
                "ID de tarea: " + idTarea + '\n' +
                "Titulo: " + titulo + '\n' +
                "Descripcion: " + descripcion + '\n' +
                "Fecha de inicio: " + fechaInicio + '\n' +
                "Fecha de finalizacion esperada: " + fechaFin + '\n' +
                "Estado: " + estado + '\n' +
                "Empleado a cargo: " + empleado.getNombre() + "\n";
    }
}

package org.arle.domain;

import java.io.Serializable;

public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCIta;
    private String nombreCita;
    private String fecha;
    private  int hora;
    private String motivo;
    Paciente paciente;


    public Cita() {}

    public Cita(int idCita,String nombreCita, String fecha, int hora, String motivo, Paciente paciente) {
        this.nombreCita = nombreCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idCIta = idCita;
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombreCita() {
        return nombreCita;
    }

    public void setNombreCita(String nombreCita) {
        this.nombreCita = nombreCita;
    }

    public int getIdCIta() {
        return idCIta;
    }

    public void setIdCIta(int idCIta) {
        this.idCIta = idCIta;
    }

    @Override
    public String toString() {
        return "Cita: \n" +
                "Id de la Cita: " + idCIta + "\n" +
                "Nombre de la Cita: " + nombreCita + "\n" +
                "Fecha: " + fecha + '\n' +
                "Hora: " + hora + "\n" +
                "Motivo: " + motivo + "\n";


    }
}

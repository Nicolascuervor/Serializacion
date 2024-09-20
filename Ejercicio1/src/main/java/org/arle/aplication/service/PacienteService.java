package org.arle.aplication.service;


import org.arle.domain.Paciente;
import org.arle.interfaces.PacienteRepository;

import java.util.List;

public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public void crearPaciente(Paciente paciente) {
        repository.save(paciente);
    }

    public Paciente obtenerPaciente(int telefono) {
        return repository.findById(telefono);
    }

    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

    public void actualizarPaciente(Paciente paciente) {
        repository.update(paciente);
    }

    public void eliminarPaciente(int telefono) {
        repository.delete(telefono);
    }
}
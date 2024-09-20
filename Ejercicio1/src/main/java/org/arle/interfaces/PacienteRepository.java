package org.arle.interfaces;

import org.arle.domain.Paciente;

import java.util.List;

public interface PacienteRepository {

    void save(Paciente paciente);

    Paciente findById(int telefono);

    List<Paciente> findAll();

    void update(Paciente paciente);

    void delete(int telefono);
}

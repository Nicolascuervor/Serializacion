package org.arle.aplication.service;


import org.arle.domain.Cita;
import org.arle.interfaces.CitaRepository;

import java.util.List;

public class CitaService {
    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public void crearCita(Cita cita) {
        repository.save(cita);
    }


    public Cita obtenerCita(int idCita) {
        return repository.findByIdCita(idCita);
    }

    public List<Cita> listarCitas() {
        return repository.findAll();
    }

    public void eliminarCita(int idCita) {
        repository.delete(idCita);
    }



}

package org.cuervo.aplication.Service;

import org.cuervo.Dominio.Tarea;
import org.cuervo.interfaces.TareaRepository;

import java.util.List;

public class TareasService {
    
    private final TareaRepository repository;


    public TareasService(TareaRepository repository) {
        this.repository = repository;
    }

    public List<Tarea> listarTareas() {
        return repository.findAll();
    }

    public void crearTarea(Tarea tarea) {
        repository.save(tarea);
    }

    public void eliminarTarea(int idTarea) {
        repository.delete(idTarea);
    }

    public void actualizarTarea(Tarea tarea) {
        repository.update(tarea);
    }

    public Tarea obtenerTarea(int idTarea) {
        return repository.findByIdTarea(idTarea);
    }



}

package org.cuervo.interfaces;

import org.cuervo.Dominio.Empleado;
import org.cuervo.Dominio.Tarea;

import java.util.List;

public interface TareaRepository {

    void save(Tarea tarea);

    void update(Tarea tarea);

    void delete(int idTarea);

    List<Tarea> findAll();

    Tarea findByIdTarea(int idTarea);
}

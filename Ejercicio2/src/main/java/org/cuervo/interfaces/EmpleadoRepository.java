package org.cuervo.interfaces;

import org.cuervo.Dominio.Empleado;

import java.util.List;

public interface EmpleadoRepository {

 void save(Empleado empleado);

 void update(Empleado empleado);

 void delete(int id);

 List<Empleado> findAll();

 Empleado findById(int id);

}

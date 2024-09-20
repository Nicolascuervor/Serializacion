package org.cuervo.aplication.Service;

import org.cuervo.Dominio.Empleado;
import org.cuervo.interfaces.EmpleadoRepository;

import java.util.List;

public class EmpleadoService {
    private final EmpleadoRepository repository;


    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }


    public void crearEmpleado(Empleado empleado) {
        repository.save(empleado);
    }

    public void actualizarEmpleado(Empleado empleado) {
        repository.update(empleado);
    }

    public Empleado obtenerEmpleado(int id) {
        return repository.findById(id);
    }

    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }


    public void eliminarEmpleado(int id) {
        repository.delete(id);
    }


}

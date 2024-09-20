package org.arle.infraestructure.repository;

import org.arle.domain.Paciente;
import org.arle.interfaces.PacienteRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePacienteRepository implements PacienteRepository {
    private static final String FILE_NAME = "empleados.dat";

    @Override
    public void save(Paciente paciente) {
        List<Paciente> pacientes = findAll();
        pacientes.add(paciente);
        saveAll(pacientes);
    }

    @Override
    public Paciente findById(int telefono) {
        return findAll().stream()
                .filter(e -> e.getTelefono() == telefono)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Paciente> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Paciente>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void update(Paciente paciente) {
        List<Paciente> pacientes = findAll();
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getTelefono() == paciente.getTelefono()) {
                pacientes.set(i, paciente);
                break;
            }
        }
        saveAll(pacientes);
    }



    @Override
    public void delete(int telefono) {
        List<Paciente> pacientes = findAll();
        pacientes.removeIf(e -> e.getTelefono() == telefono);
        saveAll(pacientes);
    }




    private void saveAll(List<Paciente> pacientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(pacientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

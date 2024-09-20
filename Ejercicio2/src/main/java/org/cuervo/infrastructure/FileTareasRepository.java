package org.cuervo.infrastructure;

import org.cuervo.Dominio.Tarea;
import org.cuervo.interfaces.TareaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTareasRepository implements TareaRepository {

    private static final String FILE_NAME = "tareas.dat";

    @Override
    public void save(Tarea tarea){
        List<Tarea> tareas = findAll();
        tareas.add(tarea);
        saveAll(tareas);
    }

    @Override
    public Tarea findByIdTarea(int idTarea) {
        return findAll().stream().filter(e -> e.getIdTarea() == idTarea).findFirst().orElse(null);
    }


    @Override
    public List<Tarea> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Tarea>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }


    @Override
    public void update(Tarea tarea) {
        List<Tarea> tareas = findAll();
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getIdTarea() == tarea.getIdTarea()) {
                tareas.set(i, tarea);
                break;
            }
        }
        saveAll(tareas);
    }


    @Override
    public void delete(int idTarea) {
        List<Tarea> tareas = findAll();
        tareas.removeIf(e -> e.getIdTarea() == idTarea);
        saveAll(tareas);
    }


    private void saveAll(List<Tarea> tareas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


package org.cuervo.aplication;


import org.cuervo.aplication.Service.EmpleadoService;
import org.cuervo.aplication.Service.TareasService;
import org.cuervo.infrastructure.FileEmpleadoRepository;
import org.cuervo.infrastructure.FileTareasRepository;
import org.cuervo.interfaces.EmpleadoRepository;
import org.cuervo.interfaces.TareaRepository;

public class Main {
    public static void main(String[] args) {

        EmpleadoRepository repository = new FileEmpleadoRepository();
        EmpleadoService service = new EmpleadoService(repository);

        TareaRepository repository1 = new FileTareasRepository();
        TareasService service1 = new TareasService(repository1);


        Ventanas ventanas = new Ventanas(service,service1);

        ventanas.iniciar();

    }
}

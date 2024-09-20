package org.arle.aplication;

import org.arle.aplication.service.CitaService;
import org.arle.aplication.service.PacienteService;
import org.arle.infraestructure.repository.FileCitaRepository;
import org.arle.infraestructure.repository.FilePacienteRepository;
import org.arle.interfaces.CitaRepository;
import org.arle.interfaces.PacienteRepository;

public class Main {
    public static void main(String[] args) {
        PacienteRepository repository = new FilePacienteRepository();
        PacienteService service = new PacienteService(repository);

        CitaRepository citaRepository = new FileCitaRepository();
        CitaService cita = new CitaService(citaRepository);

        ConsolaUI ui = new ConsolaUI(service,cita);
        ui.iniciar();
    }
}
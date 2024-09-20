package org.arle.aplication;

import org.arle.aplication.service.CitaService;
import org.arle.aplication.service.PacienteService;
import org.arle.domain.Cita;
import org.arle.domain.Direccion;
import org.arle.domain.Paciente;

import javax.swing.*;

public class ConsolaUI {
    private final PacienteService pacienteService;

    private final CitaService citaService;
   

    public ConsolaUI(PacienteService pacienteService, CitaService citaService) {
        this.pacienteService = pacienteService;
        this.citaService = citaService;
        
    }




    public void iniciar() {
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("CRUD paciente \n"
            +"1. Crear paciente \n"
            + "2. Buscar paciente\n"
            + "3. Listar pacientes\n"
            + "4. Actualizar paciente\n"
            + "5. Eliminar paciente\n"
            + "6. Crear cita\n "
            + "7. Eliminar cita \n "
            + "8. Lista de citas \n "
            + "9. Salir \n "));

            switch (opcion) {
                case 1:
                    crearPaciente();
                    break;
                case 2:
                    buscarPaciente();
                    break;
                case 3:
                    listarPacientes();
                    break;
                case 4:
                    actualizarPaciente();
                    break;
                case 5:
                    eliminarPaciente();
                    break;
                case 6:
                    crearCita();
                    break;
                case 7:
                    eliminarCita();
                    break;
                case 8:
                    listarCita();
                    break;
                case 9:
                   JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearPaciente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente: "));
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del paciente: "));
        String genero = JOptionPane.showInputDialog("Ingrese el genero del paciente: ");
        
        Paciente paciente = new Paciente(nombre, apellido, edad, telefono, genero);

        
        int numDirecciones = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas direcciones desea agregar?"));

        for (int i = 0; i < numDirecciones; i++) {
            String calle = JOptionPane.showInputDialog("Dirección #" + (i + 1) + "\n Calle: ");
           
           String ciudad = JOptionPane.showInputDialog("Ciudad: ");
           
            paciente.addDireccion(new Direccion(calle, ciudad));
        }

        pacienteService.crearPaciente(paciente);
        JOptionPane.showMessageDialog(null,"Paciente creado exitosamente.");
    }

    private void buscarPaciente() {
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del paciente"));
        Paciente paciente = pacienteService.obtenerPaciente(telefono);
        if (paciente != null) {
            JOptionPane.showMessageDialog(null, paciente);
        } else {
            JOptionPane.showMessageDialog(null,"paciente no encontrado.");
        }
    }

    private void listarPacientes() {
        System.out.println("Lista de pacientes: ");
        pacienteService.listarPacientes().forEach(System.out::println);
    }

    private void actualizarPaciente() {
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Telefono del paciente a actualizar: "));

        Paciente paciente = pacienteService.obtenerPaciente(telefono);
        if (paciente != null) {
            String nuevoNombre= JOptionPane.showInputDialog("Ingrese el nuevo nombre del paciente: ");
            String nuevoApellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
            int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente: "));
            int nuevoTelefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del paciente: "));
            String nuevoGenero = JOptionPane.showInputDialog("Ingrese el genero del paciente: ");
            paciente.setNombre(nuevoNombre);
            paciente.setApellido(nuevoApellido);
            paciente.setEdad(nuevaEdad);
            paciente.setTelefono(nuevoTelefono);
            paciente.setGenero(nuevoGenero);

            paciente.getDirecciones().clear();
            int numDirecciones = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas direcciones desea agregar? "));

            for (int i = 0; i < numDirecciones; i++) {
                String calle = JOptionPane.showInputDialog("Dirección #" + (i + 1) + "\n Calle: ");

                String ciudad = JOptionPane.showInputDialog("Ciudad: ");

                paciente.addDireccion(new Direccion(calle, ciudad));
            }

            pacienteService.actualizarPaciente(paciente);
            JOptionPane.showMessageDialog(null,"paciente actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null,"paciente no encontrado.");
        }
    }

    private void eliminarPaciente() {
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del paciente a eliminar: "));

        pacienteService.eliminarPaciente(telefono);
        JOptionPane.showMessageDialog(null,"paciente eliminado exitosamente.");
    }

    public void crearCita(){
          int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Telefono del paciente para agendarle una cita: "));
        Paciente paciente = pacienteService.obtenerPaciente(telefono);

        if (paciente != null) {
            int idCita = Integer.parseInt(JOptionPane.showInputDialog("Cree un ID para la cita: "));
            String nombreCita = JOptionPane.showInputDialog("Ingrese nombre de la cita: ");
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la cita: ");
            int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora de la cita: "));
            String motivo = JOptionPane.showInputDialog("Ingrese el motivo de la cita: ");


            Cita cita = new Cita(idCita,nombreCita,fecha,hora,motivo,paciente);
            citaService.crearCita(cita);

        }else JOptionPane.showMessageDialog(null, "Paciente no encontrado");
    }


    public void eliminarCita(){

                int idCita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita para borrarla del sistema: "));
                Cita cita = citaService.obtenerCita(idCita);

                if (cita != null){
                    citaService.eliminarCita(idCita);
                    JOptionPane.showMessageDialog(null,"Cita eliminada exitosamente.");

                } else JOptionPane.showMessageDialog(null, "Nombre de cita no encontrado");

        }

    private void listarCita() {
        System.out.println("Lista de citas: ");
    citaService.listarCitas().forEach(System.out::println);
    }
    }



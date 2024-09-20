package org.cuervo.aplication;

import org.cuervo.Dominio.Empleado;
import org.cuervo.Dominio.Tarea;
import org.cuervo.aplication.Service.EmpleadoService;
import org.cuervo.aplication.Service.TareasService;
import org.cuervo.interfaces.TareaRepository;

import javax.swing.*;

public class Ventanas {
    private final EmpleadoService empleadoService;
    private final TareasService tareasService;


    public Ventanas(EmpleadoService empleadoService, TareasService tareasService) {
        this.empleadoService = empleadoService;
        this.tareasService = tareasService;
    }

    public void iniciar(){
        while(true){
             int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion para continuar: \n " +
                    "1. Registrar nuevo empleado \n " +
                    "2. Actualizar datos del empleado\n " +
                    "3. Eliminar empleado del sistema\n " +
                    "4.Asignar tarea a empleado\n " +
                    "5. Eliminar tarea asignada\n " +
                    "6.Lista de empleados registrados\n " +
                    "7. Mostrar tareas asignadas a empleado\n " +
                    "8. Actualizar estado de tarea \n " +
                    "9. Salir del programa "));


             switch (opcion){
                 case 1:
                     registrarEmpleado();
                     break;
                 case 2:
                     actualizarEmpleado();
                     break;
                 case 3:
                     borrarEmpleado();
                     break;
                 case 4:
                     crearTarea();
                     break;
                 case 5:
                     eliminarTarea();
                     break;
                 case 6:
                     listarEmpleados();
                     break;
                 case 7:
                     listaTareas();
                     break;
                 case 8:
                     actualizarEstadoTarea();
                     break;
                 case 9:
                     JOptionPane.showMessageDialog(null, "Gracias por usar el programa, Vuelva pronto");
                     return;
                 default:
                     JOptionPane.showMessageDialog(null,"Opción no válida. Intente de nuevo.");

             }
        }
    }

    public void registrarEmpleado(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado: "));
        String nombreEmpleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
        String apellidoEmpleado = JOptionPane.showInputDialog("Ingrese el apellido del empleado: ");
        String edadEmpleado = JOptionPane.showInputDialog("Ingrese la edad del empleado: ");
        String cargoEmpleado = JOptionPane.showInputDialog("Ingrese el cargo del empleado: ");
        String departamentoEmpleado = JOptionPane.showInputDialog("Ingrese el departamento del empleado: ");
        int salarioEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario del empleado: "));

        Empleado empleado = new Empleado(id,nombreEmpleado,apellidoEmpleado,edadEmpleado,cargoEmpleado,departamentoEmpleado,salarioEmpleado);

        empleadoService.crearEmpleado(empleado);

        JOptionPane.showMessageDialog(null, "Empleado creado exitosamente");

    }

    public void actualizarEmpleado(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado para cambiar sus datos (el ID es irremplazable): "));

        Empleado empleado = empleadoService.obtenerEmpleado(id);

        if(empleado != null){
            String nuevoNombreEmpleado = JOptionPane.showInputDialog("Ingrese el nuevo nombre del empleado: ");
            empleado.setNombre(nuevoNombreEmpleado);

            String nuevoApellidoEmpleado = JOptionPane.showInputDialog("Ingrese el nuevo apellido del empleado: ");
            empleado.setApellido(nuevoApellidoEmpleado);

            String nuevoEdadEmpleado = JOptionPane.showInputDialog("Ingrese la edad nueva del empleado: ");
            empleado.setEdad(nuevoEdadEmpleado);

            String nuevoCargoEmpleado = JOptionPane.showInputDialog("Ingrese el cargo nuevo del empleado: ");
            empleado.setCargo(nuevoCargoEmpleado);

            String nuevoDepartamentoEmpleado = JOptionPane.showInputDialog("Ingrese el departamento nuevo del empleado: ");
            empleado.setDepartamento(nuevoDepartamentoEmpleado);

            int nuevoSalarioEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario nuevo del empleado: "));
            empleado.setSalario(nuevoSalarioEmpleado);


            empleadoService.actualizarEmpleado(empleado);

            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente");
        } else JOptionPane.showMessageDialog(null,"Empleado no encontrado");


    }

    public void borrarEmpleado(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado para borrar sus datos: "));
        empleadoService.eliminarEmpleado(id);
        JOptionPane.showMessageDialog(null, "Empleado borrado exitosamente");

    }

    public void listarEmpleados(){
        System.out.println("Lista de empleados:\n ");
        empleadoService.listarEmpleados().forEach(System.out::println);

    }

    public void crearTarea(){
        int idTarea = Integer.parseInt(JOptionPane.showInputDialog("Asignele un id a la tarea: "));
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la tarea: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la tarea: ");
        String fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio. formato d/m/a: ");
        String fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de finalizacion esperada. formato d/m/a: ");
        String estado = JOptionPane.showInputDialog("Ingrese la estado de la tarea: ");

        while (true){
            int empleadoEscogido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de un empleado para asignarle la tarea: "));

            Empleado empleado = empleadoService.obtenerEmpleado(empleadoEscogido);

            if(empleado != null){
                Tarea tarea = new Tarea(idTarea,titulo,descripcion,fechaInicio,fechaFin,estado,empleado);
                tareasService.crearTarea(tarea);
                JOptionPane.showMessageDialog(null, "Tarea asignada exitosamente");
                return;
            }
            else JOptionPane.showMessageDialog(null,"Empleado no encontrado");
        }
    }

    public void eliminarTarea(){
       int idTarea = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la tarea para eliminarla: "));

        tareasService.eliminarTarea(idTarea);
        JOptionPane.showMessageDialog(null,"Tarea elimada exitosamente");

    }

    public void actualizarEstadoTarea(){
        int idTarea = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la tarea para cambiar su estado: "));

        Tarea tarea = tareasService.obtenerTarea(idTarea);

        if(tarea != null){
            String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la tarea: \n Estado actual: " + tarea.getEstado());
            tarea.setEstado(nuevoEstado);

            tareasService.actualizarTarea(tarea);
            JOptionPane.showMessageDialog(null, "Estado actualizado exitosamente");
        }
        else JOptionPane.showMessageDialog(null,"Tarea no encontrada");
    }




    public void listaTareas(){
        System.out.println("Lista de tareas:\n ");
        tareasService.listarTareas().forEach(System.out::println);
    }



}

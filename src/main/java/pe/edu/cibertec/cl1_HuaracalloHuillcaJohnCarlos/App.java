package pe.edu.cibertec.cl1_HuaracalloHuillcaJohnCarlos;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import antlr.collections.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.cl1_HuaracalloHuillcaJohnCarlos.models.Empleado;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmpleadoGestor gestor = new EmpleadoGestor();

        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setApellidoPaterno("Perez");
        nuevoEmpleado.setApellidoMaterno("Gomez");
        nuevoEmpleado.setNombres("Juan");
        nuevoEmpleado.setNroHijos(2);
        nuevoEmpleado.setSueldo(45000.0);
        nuevoEmpleado.setFechaNacimiento(LocalDate.of(1980, 7, 15));

        gestor.guardarEmpleado(nuevoEmpleado);

        Empleado empleadoBuscado = gestor.buscarEmpleadoPorId(1);

        if (empleadoBuscado != null) {
            System.out.println("Empleado encontrado: " + empleadoBuscado);
        } else {
            System.out.println("Empleado no encontrado.");
        }

        if (empleadoBuscado != null) {
            empleadoBuscado.setSueldo(48000.0);
            gestor.modificarEmpleado(empleadoBuscado);
            System.out.println("Empleado modificado: " + empleadoBuscado);
        }

        if (empleadoBuscado != null) {
            gestor.eliminarEmpleado(empleadoBuscado.getId());
            System.out.println("Empleado eliminado.");
        }


        gestor.close();
    }
}

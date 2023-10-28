package pe.edu.cibertec.cl1_HuaracalloHuillcaJohnCarlos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.cl1_HuaracalloHuillcaJohnCarlos.models.Empleado;

public class EmpleadoGestor {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Empleado");
    private EntityManager em = emf.createEntityManager();

    public void close() {
        em.close();
        emf.close();
    }

    public void guardarEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleadoPorId(long i) {
        return em.find(Empleado.class, i);
    }

    public void modificarEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
    }

    public void eliminarEmpleado(Long id) {
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        }
    }

    public List<Empleado> listarTodosLosEmpleados() {
        TypedQuery<Empleado> query = (TypedQuery<Empleado>) em.createNamedQuery("Empleado.listarTodos", Empleado.class);
        return query.getResultList();
    }
}

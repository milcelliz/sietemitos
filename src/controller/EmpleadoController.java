/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.PersistenceUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Categorias;
import model.Empleados;

/**
 *
 * @author isaacamarilla
 */
public class EmpleadoController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Empleados> listar(){
        List<Empleados> lista = em.createNamedQuery("Empleados.findActivos", Empleados.class).getResultList();
        return lista;
    }
    public static Empleados mostrar(int id){
        Empleados empleados = em.find(Empleados.class, id);
        return empleados;
    } 
    public static void insertar(Empleados empleados){
        em.getTransaction().begin();
        em.persist(empleados);
        em.getTransaction().commit();
    }
    public static void actualizar(Empleados empleados){
        Empleados emple= em.find(Empleados.class, empleados.getId());
        em.getTransaction().begin();
        emple.setNombre(empleados.getNombre());
        emple.setRol(empleados.getRol());
        emple.setDireccion(empleados.getDireccion());
       
        emple.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Empleados empleados = em.find(Empleados.class, id);
        em.getTransaction().begin();
        empleados.setBorrado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(Empleados empleados){
        borrar(empleados.getId());
    }
    public static void crear(){
    }
    public static void editar(Empleados empleados){
    }
    
    
}

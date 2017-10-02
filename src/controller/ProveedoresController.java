/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Proveedores;

/**
 *
 * @author isaacamarilla
 */
public class ProveedoresController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Proveedores> listar(){
        List<Proveedores> lista = em.createNamedQuery("Proveedores.findActivos", Proveedores.class).getResultList();
        return lista;
    }
    public static Proveedores mostrar(int id){
        Proveedores proveedores = em.find(Proveedores.class, id);
        return proveedores;
    } 
    public static void insertar(Proveedores proveedores){
        em.getTransaction().begin();
        em.persist(proveedores);
        em.getTransaction().commit();
    }
    public static void actualizar(Proveedores proveedores){
        Proveedores provee= em.find(Proveedores.class, proveedores.getId());
        em.getTransaction().begin();
        provee.setNombre(proveedores.getNombre());
        provee.setTelefono(proveedores.getTelefono());
        provee.setDireccion(proveedores.getDireccion());
        provee.setBorrado(proveedores.getBorrado());
        provee.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Proveedores proveedores = em.find(Proveedores.class, id);
        em.getTransaction().begin();
        proveedores.setBorrado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(Proveedores proveedores){
        borrar(proveedores.getId());
    }
    public static void crear(){
    }
    public static void editar(Proveedores proveedoress){
    }
    

}

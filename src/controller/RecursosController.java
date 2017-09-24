/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Recursos;

/**
 *
 * @author isaacamarilla
 */
public class RecursosController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Recursos> listar(){
        List<Recursos> lista = em.createNamedQuery("Recursos.findByBorrado", Recursos.class).setParameter("borrado","NULL").getResultList();
        return lista;
    }
    public static Recursos mostrar(int id){
        Recursos proveedores = em.find(Recursos.class, id);
        return proveedores;
    } 
    public static void insertar(Recursos recursos){
        em.getTransaction().begin();
        em.persist(recursos);
        em.getTransaction().commit();
    }
    public static void actualizar(Recursos recursos){
        Recursos recur= em.find(Recursos.class, recursos.getId());
        em.getTransaction().begin();
        recur.setNombre(recursos.getNombre());
        recur.setPrecio(recursos.getPrecio());
        recur.setExistencia(recursos.getExistencia());
        recur.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Recursos recur = em.find(Recursos.class, id);
        em.getTransaction().begin();
        recur.setBorrado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(Recursos recur){
        borrar(recur.getId());
    }
    public static void crear(){
    }
    public static void editar(Recursos recursos){
    }
    

    
}

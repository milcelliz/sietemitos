/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Clientes;

/**
 *
 * @author isaacamarilla
 */
public class ClienteController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Clientes> listar(){
        List<Clientes> lista = em.createNamedQuery("Clientes.findByBorrado", Clientes.class).setParameter("borrado", "NULL").getResultList();
        return lista;
    }
    public static Clientes mostrar(int id){
        Clientes cliente = em.find(Clientes.class, id);
        return cliente;
    } 
    public static void insertar(Clientes cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    public static void actualizar(Clientes clientes){
        Clientes cliente= em.find(Clientes.class, clientes.getId());
        em.getTransaction().begin();
        cliente.setNombre(clientes.getNombre());
        cliente.setRuc(clientes.getRuc());
        cliente.setTelefono(clientes.getTelefono());
        cliente.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Clientes cliente = em.find(Clientes.class, id);
        em.getTransaction().begin();
        cliente.setBorrado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(Clientes clientes){
        borrar(clientes.getId());
    }
    public static void crear(){
    }
    public static void editar(Clientes clientes){
    }
    
}

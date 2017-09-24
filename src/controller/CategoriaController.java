/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Categorias;

/**
 *
 * @author isaacamarilla
 */
public class CategoriaController {

    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Categorias> listar(){
        List<Categorias> lista = em.createNamedQuery("Categorias.findAll", Categorias.class).getResultList();
        return lista;
    }
    public static Categorias mostrar(int id){
        Categorias categorias = em.find(Categorias.class, id);
        return categorias;
    } 
    public static void insertar(Categorias categorias){
        em.getTransaction().begin();
        em.persist(categorias);
        em.getTransaction().commit();
    }
    public static void actualizar(Categorias categorias){
        Categorias categoria= em.find(Categorias.class, categorias.getId());
        em.getTransaction().begin();
        categoria.setNombre(categoria.getNombre());
        categoria.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Categorias categorias = em.find(Categorias.class, id);
        em.getTransaction().begin();
        em.remove(categorias);
        em.getTransaction().commit();
        
    }
    public static void borrar(Categorias categorias){
        borrar(categorias.getId());
    }
    public static void crear(){
    }
    public static void editar(Categorias categorias){
    }
    
}

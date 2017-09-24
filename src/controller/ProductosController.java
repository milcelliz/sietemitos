/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Productos;

/**
 *
 * @author isaacamarilla
 */
public class ProductosController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Productos> listar(){
        List<Productos> lista = em.createNamedQuery("Productos.findByBorrado", Productos.class).setParameter("borrado","NULL").getResultList();
        return lista;
    }
    public static Productos mostrar(int id){
        Productos productos = em.find(Productos.class, id);
        return productos;
    } 
    public static void insertar(Productos productos){
        em.getTransaction().begin();
        em.persist(productos);
        em.getTransaction().commit();
    }
    public static void actualizar(Productos productos){
        Productos producto= em.find(Productos.class, productos.getId());
        em.getTransaction().begin();
        producto.setNombre(productos.getNombre());
        producto.setPrecio(productos.getPrecio());
        producto.setCategoriasId(productos.getCategoriasId());
        producto.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(int id){
        Productos productos = em.find(Productos.class, id);
        em.getTransaction().begin();
        productos.setBorrado(new Date());
        em.getTransaction().commit();
        
    }
    public static void borrar(Productos productos){
        borrar(productos.getId());
    }
    public static void crear(){
    }
    public static void editar(Productos productos){
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Compras;

/**
 *
 * @author isaacamarilla
 */
public class ComprasController {
        private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Compras> listar(){
        List<Compras> lista = em.createNamedQuery("Compras.findAll", Compras.class).getResultList();
        return lista;
    }
    public static Compras mostrar(int id){
        Compras compra = em.find(Compras.class, id);
        return compra;
    } 
    public static void insertar(Compras compra){
        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
    }
    public static void actualizar(Compras compras){
        Compras compra= em.find(Compras.class, compras.getId());
        em.getTransaction().begin();
        compra.setNroFactura(compras.getNroFactura());
        compra.setProveedoresId(compras.getProveedoresId());
        compra.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
}

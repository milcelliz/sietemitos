
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.Empleados;
import model.Facturas;
import model.Proveedores;

/**
 *
 * @author isaacamarilla
 */
public class FacturaController {
    private static EntityManager em = PersistenceUtil.getEntityManager();
    
    public static List<Facturas> listar(){
        List<Facturas> lista = em.createNamedQuery("Facturas.findAll", Facturas.class).getResultList();
        return lista;
    }
    public static Facturas mostrar(int id){
        Facturas facturas = em.find(Facturas.class, id);
        return facturas;
    } 
    public static void insertar(Facturas facturas){
        em.getTransaction().begin();
        em.persist(facturas);
        em.getTransaction().commit();
    }
    public static void actualizar(Facturas facturas){
        Facturas factura= em.find(Facturas.class, facturas.getId());
        em.getTransaction().begin();
        
        factura.setNroFactura(facturas.getNroFactura());
        factura.setClientesId(facturas.getClientesId());
         factura.setEmpleadosId(facturas.getEmpleadosId());
        factura.setTotal(facturas.getTotal());
        factura.setActualizado(new Date());
        em.getTransaction().commit();
        
    }
    
   
    public static void crear(){
    }
    public static void editar(Facturas facturas){
    }
}

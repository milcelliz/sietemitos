/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sietemitos;

import controller.PersistenceUtil;
import controller.ProductosController;
import controller.RecursosController;
import javax.persistence.EntityManager;
import model.ProductosRecursos;
import model.ProductosRecursosPK;
import view.InicioVista;

/**
 *
 * @author isaacamarilla
 */
public class SieteMitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(() -> {
            new InicioVista().setVisible(true);
        });
        
        
    }

    public static void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

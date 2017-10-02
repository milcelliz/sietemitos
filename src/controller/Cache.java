/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.prefs.Preferences;
import model.Clientes;
import model.Empleados;

/**
 *
 * @author Dante
 */
public class Cache {

    static void set(Integer empleadosId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void setUsuario(int id){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        prefs.putInt("usuario", id);
    }
    public static Empleados getEmpleado(){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        int id = prefs.getInt("usuario", 0);
        Empleados empleado = EmpleadoController.mostrar(id);
        return empleado;
    }
    
    static void setCliente(Integer clienteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void setUsuario2(int id){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        prefs.putInt("cliente", id);
    }
    public static Clientes getClientes(){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        int id = prefs.getInt("usuario", 0);
        Clientes cliente = ClienteController.mostrar(id);
        return cliente;
    }
    
    static void setProveedores(Integer proveedorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void setUsuario3(int id){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        prefs.putInt("cliente", id);
    }
    public static Clientes getProveedores(){
        Preferences prefs = Preferences.userNodeForPackage(controller.Cache.class);
        int id = prefs.getInt("usuario", 0);
        Clientes cliente = ClienteController.mostrar(id);
        return cliente;
    }
    
}

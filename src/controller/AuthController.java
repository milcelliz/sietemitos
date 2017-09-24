/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import model.Usuarios;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.prefs.Preferences;

/**
 *
 
 */
public class AuthController {
    private static final EntityManager em = PersistenceUtil.getEntityManager();
    
    public static boolean login(String user, String pass){
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(pass.getBytes());
            byte [] passBytes = messageDigest.digest();
            StringBuffer sbf = new StringBuffer();
            for(byte passByte : passBytes){
                sbf.append(String.format("%02x", passByte & 0xff));
            }
            String passMd5 = sbf.toString();
            List<Usuarios> lista = em.createNamedQuery("Usuarios.login", Usuarios.class).setParameter("user",user).setParameter("pass", passMd5).getResultList();
            
            if(!lista.isEmpty()){ //el metodo ve si esta vacio la lista
                Usuarios usuario = lista.get(0);
                System.out.println(usuario.toString());
                Cache.setUsuario(usuario.getEmpleadosId());
                return true;
            }
        } catch (NoSuchAlgorithmException ex) {
        }
         return false;
    }
}

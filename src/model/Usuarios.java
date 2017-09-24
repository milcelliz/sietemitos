/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dante
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.login", query = "SELECT u FROM Usuarios u WHERE u.usuario = :user AND u.contrasena = :pass"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuarios.findByEmpleadosId", query = "SELECT u FROM Usuarios u WHERE u.empleadosId = :empleadosId")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Id
    @Basic(optional = false)
    @Column(name = "empleados_id")
    private Integer empleadosId;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;

    public Usuarios() {
    }

    public Usuarios(Integer empleadosId) {
        this.empleadosId = empleadosId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Integer empleadosId) {
        this.empleadosId = empleadosId;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosId != null ? empleadosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.empleadosId == null && other.empleadosId != null) || (this.empleadosId != null && !this.empleadosId.equals(other.empleadosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuarios[ empleadosId=" + empleadosId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dante
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio"),
    @NamedQuery(name = "Productos.findByCreado", query = "SELECT p FROM Productos p WHERE p.creado = :creado"),
    @NamedQuery(name = "Productos.findByActualizado", query = "SELECT p FROM Productos p WHERE p.actualizado = :actualizado"),
    @NamedQuery(name = "Productos.findByBorrado", query = "SELECT p FROM Productos p WHERE p.borrado = :borrado")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @Column(name = "borrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrado;
    @JoinTable(name = "productos_recursos", joinColumns = {
        @JoinColumn(name = "productos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "recursos_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Recursos> recursosCollection;
    @JoinColumn(name = "categorias_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias categoriasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<DetallesFacturas> detallesFacturasCollection;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public Date getBorrado() {
        return borrado;
    }

    public void setBorrado(Date borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    public Categorias getCategoriasId() {
        return categoriasId;
    }

    public void setCategoriasId(Categorias categoriasId) {
        this.categoriasId = categoriasId;
    }

    @XmlTransient
    public Collection<DetallesFacturas> getDetallesFacturasCollection() {
        return detallesFacturasCollection;
    }

    public void setDetallesFacturasCollection(Collection<DetallesFacturas> detallesFacturasCollection) {
        this.detallesFacturasCollection = detallesFacturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Productos[ id=" + id + " ]";
    }
    
}

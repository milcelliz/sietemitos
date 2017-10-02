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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findById", query = "SELECT r FROM Recursos r WHERE r.id = :id"),
    @NamedQuery(name = "Recursos.findByNombre", query = "SELECT r FROM Recursos r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Recursos.findByPrecio", query = "SELECT r FROM Recursos r WHERE r.precio = :precio"),
    @NamedQuery(name = "Recursos.findByBorrado", query = "SELECT r FROM Recursos r WHERE r.borrado = :borrado"),
    @NamedQuery(name = "Recursos.findByExistencia", query = "SELECT r FROM Recursos r WHERE r.existencia = :existencia"),
    @NamedQuery(name = "Recursos.findByCreado", query = "SELECT r FROM Recursos r WHERE r.creado = :creado"),
    @NamedQuery(name = "Recursos.findByActualizado", query = "SELECT r FROM Recursos r WHERE r.actualizado = :actualizado")})
public class Recursos implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recursos")
    private Collection<ProductosRecursos> productosRecursosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private String precio;
    @Column(name = "borrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrado;
    @Column(name = "existencia")
    private Integer existencia;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @ManyToMany(mappedBy = "recursosCollection")
    private Collection<Productos> productosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recursos")
    private Collection<DetalleCompra> detalleCompraCollection;

    public Recursos() {
    }

    public Recursos(Integer id) {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Date getBorrado() {
        return borrado;
    }

    public void setBorrado(Date borrado) {
        this.borrado = borrado;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
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

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @XmlTransient
    public Collection<DetalleCompra> getDetalleCompraCollection() {
        return detalleCompraCollection;
    }

    public void setDetalleCompraCollection(Collection<DetalleCompra> detalleCompraCollection) {
        this.detalleCompraCollection = detalleCompraCollection;
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
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recursos[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ProductosRecursos> getProductosRecursosCollection() {
        return productosRecursosCollection;
    }

    public void setProductosRecursosCollection(Collection<ProductosRecursos> productosRecursosCollection) {
        this.productosRecursosCollection = productosRecursosCollection;
    }
    
}

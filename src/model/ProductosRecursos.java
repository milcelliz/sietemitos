/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dante
 */
@Entity
@Table(name = "productos_recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosRecursos.findAll", query = "SELECT p FROM ProductosRecursos p"),
    @NamedQuery(name = "ProductosRecursos.findByRecursosId", query = "SELECT p FROM ProductosRecursos p WHERE p.productosRecursosPK.recursosId = :recursosId"),
    @NamedQuery(name = "ProductosRecursos.findByProductosId", query = "SELECT p FROM ProductosRecursos p WHERE p.productosRecursosPK.productosId = :productosId"),
    @NamedQuery(name = "ProductosRecursos.findByCantidad", query = "SELECT p FROM ProductosRecursos p WHERE p.cantidad = :cantidad")})
public class ProductosRecursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosRecursosPK productosRecursosPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "productos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "recursos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recursos recursos;

    public ProductosRecursos() {
    }

    public ProductosRecursos(ProductosRecursosPK productosRecursosPK) {
        this.productosRecursosPK = productosRecursosPK;
    }

    public ProductosRecursos(ProductosRecursosPK productosRecursosPK, int cantidad) {
        this.productosRecursosPK = productosRecursosPK;
        this.cantidad = cantidad;
    }

    public ProductosRecursos(int recursosId, int productosId) {
        this.productosRecursosPK = new ProductosRecursosPK(recursosId, productosId);
    }

    public ProductosRecursosPK getProductosRecursosPK() {
        return productosRecursosPK;
    }

    public void setProductosRecursosPK(ProductosRecursosPK productosRecursosPK) {
        this.productosRecursosPK = productosRecursosPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosRecursosPK != null ? productosRecursosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosRecursos)) {
            return false;
        }
        ProductosRecursos other = (ProductosRecursos) object;
        if ((this.productosRecursosPK == null && other.productosRecursosPK != null) || (this.productosRecursosPK != null && !this.productosRecursosPK.equals(other.productosRecursosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProductosRecursos[ productosRecursosPK=" + productosRecursosPK + " ]";
    }
    
}

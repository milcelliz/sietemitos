/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "detalles_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesFacturas.findAll", query = "SELECT d FROM DetallesFacturas d"),
    @NamedQuery(name = "DetallesFacturas.findByProductosId", query = "SELECT d FROM DetallesFacturas d WHERE d.detallesFacturasPK.productosId = :productosId"),
    @NamedQuery(name = "DetallesFacturas.findByFacturasId", query = "SELECT d FROM DetallesFacturas d WHERE d.detallesFacturasPK.facturasId = :facturasId"),
    @NamedQuery(name = "DetallesFacturas.findByPrecio", query = "SELECT d FROM DetallesFacturas d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetallesFacturas.findByCantidad", query = "SELECT d FROM DetallesFacturas d WHERE d.cantidad = :cantidad")})
public class DetallesFacturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesFacturasPK detallesFacturasPK;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "facturas_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facturas facturas;
    @JoinColumn(name = "productos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public DetallesFacturas() {
    }

    public DetallesFacturas(DetallesFacturasPK detallesFacturasPK) {
        this.detallesFacturasPK = detallesFacturasPK;
    }

    public DetallesFacturas(int productosId, int facturasId) {
        this.detallesFacturasPK = new DetallesFacturasPK(productosId, facturasId);
    }

    public DetallesFacturasPK getDetallesFacturasPK() {
        return detallesFacturasPK;
    }

    public void setDetallesFacturasPK(DetallesFacturasPK detallesFacturasPK) {
        this.detallesFacturasPK = detallesFacturasPK;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesFacturasPK != null ? detallesFacturasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesFacturas)) {
            return false;
        }
        DetallesFacturas other = (DetallesFacturas) object;
        if ((this.detallesFacturasPK == null && other.detallesFacturasPK != null) || (this.detallesFacturasPK != null && !this.detallesFacturasPK.equals(other.detallesFacturasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetallesFacturas[ detallesFacturasPK=" + detallesFacturasPK + " ]";
    }
    
}

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
@Table(name = "detalle_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d"),
    @NamedQuery(name = "DetalleCompra.findByRecursosId", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.recursosId = :recursosId"),
    @NamedQuery(name = "DetalleCompra.findByComprasId", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.comprasId = :comprasId"),
    @NamedQuery(name = "DetalleCompra.findByPrecio", query = "SELECT d FROM DetalleCompra d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetalleCompra.findByCant", query = "SELECT d FROM DetalleCompra d WHERE d.cant = :cant")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCompraPK detalleCompraPK;
    @Column(name = "precio")
    private String precio;
    @Column(name = "cant")
    private String cant;
    @JoinColumn(name = "compras_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compras compras;
    @JoinColumn(name = "recursos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recursos recursos;

    public DetalleCompra() {
    }

    public DetalleCompra(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public DetalleCompra(int recursosId, int comprasId) {
        this.detalleCompraPK = new DetalleCompraPK(recursosId, comprasId);
    }

    public DetalleCompraPK getDetalleCompraPK() {
        return detalleCompraPK;
    }

    public void setDetalleCompraPK(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
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
        hash += (detalleCompraPK != null ? detalleCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.detalleCompraPK == null && other.detalleCompraPK != null) || (this.detalleCompraPK != null && !this.detalleCompraPK.equals(other.detalleCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetalleCompra[ detalleCompraPK=" + detalleCompraPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dante
 */
@Embeddable
public class DetallesFacturasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "productos_id")
    private int productosId;
    @Basic(optional = false)
    @Column(name = "facturas_id")
    private int facturasId;

    public DetallesFacturasPK() {
    }

    public DetallesFacturasPK(int productosId, int facturasId) {
        this.productosId = productosId;
        this.facturasId = facturasId;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }

    public int getFacturasId() {
        return facturasId;
    }

    public void setFacturasId(int facturasId) {
        this.facturasId = facturasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productosId;
        hash += (int) facturasId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesFacturasPK)) {
            return false;
        }
        DetallesFacturasPK other = (DetallesFacturasPK) object;
        if (this.productosId != other.productosId) {
            return false;
        }
        if (this.facturasId != other.facturasId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetallesFacturasPK[ productosId=" + productosId + ", facturasId=" + facturasId + " ]";
    }
    
}

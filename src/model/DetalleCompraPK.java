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
public class DetalleCompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "recursos_id")
    private int recursosId;
    @Basic(optional = false)
    @Column(name = "compras_id")
    private int comprasId;

    public DetalleCompraPK() {
    }

    public DetalleCompraPK(int recursosId, int comprasId) {
        this.recursosId = recursosId;
        this.comprasId = comprasId;
    }

    public int getRecursosId() {
        return recursosId;
    }

    public void setRecursosId(int recursosId) {
        this.recursosId = recursosId;
    }

    public int getComprasId() {
        return comprasId;
    }

    public void setComprasId(int comprasId) {
        this.comprasId = comprasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recursosId;
        hash += (int) comprasId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompraPK)) {
            return false;
        }
        DetalleCompraPK other = (DetalleCompraPK) object;
        if (this.recursosId != other.recursosId) {
            return false;
        }
        if (this.comprasId != other.comprasId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetalleCompraPK[ recursosId=" + recursosId + ", comprasId=" + comprasId + " ]";
    }
    
}

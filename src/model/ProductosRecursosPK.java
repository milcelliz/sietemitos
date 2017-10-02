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
public class ProductosRecursosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "recursos_id")
    private int recursosId;
    @Basic(optional = false)
    @Column(name = "productos_id")
    private int productosId;

    public ProductosRecursosPK() {
    }

    public ProductosRecursosPK(int recursosId, int productosId) {
        this.recursosId = recursosId;
        this.productosId = productosId;
    }

    public int getRecursosId() {
        return recursosId;
    }

    public void setRecursosId(int recursosId) {
        this.recursosId = recursosId;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recursosId;
        hash += (int) productosId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosRecursosPK)) {
            return false;
        }
        ProductosRecursosPK other = (ProductosRecursosPK) object;
        if (this.recursosId != other.recursosId) {
            return false;
        }
        if (this.productosId != other.productosId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProductosRecursosPK[ recursosId=" + recursosId + ", productosId=" + productosId + " ]";
    }
    
}

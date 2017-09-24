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
import javax.persistence.JoinColumn;
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
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findById", query = "SELECT f FROM Facturas f WHERE f.id = :id"),
    @NamedQuery(name = "Facturas.findByNroFactura", query = "SELECT f FROM Facturas f WHERE f.nroFactura = :nroFactura"),
    @NamedQuery(name = "Facturas.findByCreado", query = "SELECT f FROM Facturas f WHERE f.creado = :creado"),
    @NamedQuery(name = "Facturas.findByActualizado", query = "SELECT f FROM Facturas f WHERE f.actualizado = :actualizado"),
    @NamedQuery(name = "Facturas.findByTotal", query = "SELECT f FROM Facturas f WHERE f.total = :total")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nro_factura")
    private String nroFactura;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes clientesId;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados empleadosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private Collection<DetallesFacturas> detallesFacturasCollection;

    public Facturas() {
    }

    public Facturas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Clientes getClientesId() {
        return clientesId;
    }

    public void setClientesId(Clientes clientesId) {
        this.clientesId = clientesId;
    }

    public Empleados getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Empleados empleadosId) {
        this.empleadosId = empleadosId;
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
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Facturas[ id=" + id + " ]";
    }
    
}

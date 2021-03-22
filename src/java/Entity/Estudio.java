/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "ESTUDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e")
    , @NamedQuery(name = "Estudio.findByIdestudio", query = "SELECT e FROM Estudio e WHERE e.idestudio = :idestudio")
    , @NamedQuery(name = "Estudio.findByDescripcion", query = "SELECT e FROM Estudio e WHERE e.descripcion = :descripcion")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTUDIO")
    private Integer idestudio;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Lob
    @Size(max = 32700)
    @Column(name = "RESULTADO")
    private String resultado;
    @JoinColumn(name = "ANALISTA", referencedColumnName = "ID")
    @ManyToOne
    private Usuario analista;

    public Estudio() {
    }

    public Estudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public Integer getIdestudio() {
        return idestudio;
    }

    public void setIdestudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Usuario getAnalista() {
        return analista;
    }

    public void setAnalista(Usuario analista) {
        this.analista = analista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudio != null ? idestudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idestudio == null && other.idestudio != null) || (this.idestudio != null && !this.idestudio.equals(other.idestudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Estudio[ idestudio=" + idestudio + " ]";
    }
    
}

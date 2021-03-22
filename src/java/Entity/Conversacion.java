/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "CONVERSACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversacion.findAll", query = "SELECT c FROM Conversacion c")
    , @NamedQuery(name = "Conversacion.findByIdconversacion", query = "SELECT c FROM Conversacion c WHERE c.idconversacion = :idconversacion")
    , @NamedQuery(name = "Conversacion.findByAsunto", query = "SELECT c FROM Conversacion c WHERE c.asunto = :asunto")
    , @NamedQuery(name = "Conversacion.findByFechacreacion", query = "SELECT c FROM Conversacion c WHERE c.fechacreacion = :fechacreacion")})
public class Conversacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONVERSACION")
    private Integer idconversacion;
    @Size(max = 55)
    @Column(name = "ASUNTO")
    private String asunto;
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "TELEOPERADOR", referencedColumnName = "ID")
    @ManyToOne
    private Usuario teleoperador;
    @OneToMany(mappedBy = "conversacion")
    private List<Mensaje> mensajeList;

    public Conversacion() {
    }

    public Conversacion(Integer idconversacion) {
        this.idconversacion = idconversacion;
    }

    public Integer getIdconversacion() {
        return idconversacion;
    }

    public void setIdconversacion(Integer idconversacion) {
        this.idconversacion = idconversacion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getTeleoperador() {
        return teleoperador;
    }

    public void setTeleoperador(Usuario teleoperador) {
        this.teleoperador = teleoperador;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconversacion != null ? idconversacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversacion)) {
            return false;
        }
        Conversacion other = (Conversacion) object;
        if ((this.idconversacion == null && other.idconversacion != null) || (this.idconversacion != null && !this.idconversacion.equals(other.idconversacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Conversacion[ idconversacion=" + idconversacion + " ]";
    }
    
}

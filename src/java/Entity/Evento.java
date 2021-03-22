/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByTitulo", query = "SELECT e FROM Evento e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Evento.findByDescripcion", query = "SELECT e FROM Evento e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Evento.findByFechaevento", query = "SELECT e FROM Evento e WHERE e.fechaevento = :fechaevento")
    , @NamedQuery(name = "Evento.findByFechalimitereserva", query = "SELECT e FROM Evento e WHERE e.fechalimitereserva = :fechalimitereserva")
    , @NamedQuery(name = "Evento.findByCoste", query = "SELECT e FROM Evento e WHERE e.coste = :coste")
    , @NamedQuery(name = "Evento.findByAforo", query = "SELECT e FROM Evento e WHERE e.aforo = :aforo")
    , @NamedQuery(name = "Evento.findByMaxentradas", query = "SELECT e FROM Evento e WHERE e.maxentradas = :maxentradas")
    , @NamedQuery(name = "Evento.findByAsientosfijos", query = "SELECT e FROM Evento e WHERE e.asientosfijos = :asientosfijos")
    , @NamedQuery(name = "Evento.findByNumerofilas", query = "SELECT e FROM Evento e WHERE e.numerofilas = :numerofilas")
    , @NamedQuery(name = "Evento.findByAsientosfila", query = "SELECT e FROM Evento e WHERE e.asientosfila = :asientosfila")
    , @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.idevento = :idevento")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 55)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHAEVENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaevento;
    @Column(name = "FECHALIMITERESERVA")
    @Temporal(TemporalType.DATE)
    private Date fechalimitereserva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTE")
    private Double coste;
    @Column(name = "AFORO")
    private Integer aforo;
    @Lob
    @Size(max = 32700)
    @Column(name = "ETIQUETAS")
    private String etiquetas;
    @Column(name = "MAXENTRADAS")
    private Integer maxentradas;
    @Column(name = "ASIENTOSFIJOS")
    private Boolean asientosfijos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROFILAS")
    private int numerofilas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIENTOSFILA")
    private int asientosfila;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEVENTO")
    private Integer idevento;
    @JoinColumn(name = "USUARIOCREADOR", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuariocreador;

    public Evento() {
    }

    public Evento(Integer idevento) {
        this.idevento = idevento;
    }

    public Evento(Integer idevento, int numerofilas, int asientosfila) {
        this.idevento = idevento;
        this.numerofilas = numerofilas;
        this.asientosfila = asientosfila;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(Date fechaevento) {
        this.fechaevento = fechaevento;
    }

    public Date getFechalimitereserva() {
        return fechalimitereserva;
    }

    public void setFechalimitereserva(Date fechalimitereserva) {
        this.fechalimitereserva = fechalimitereserva;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Integer getMaxentradas() {
        return maxentradas;
    }

    public void setMaxentradas(Integer maxentradas) {
        this.maxentradas = maxentradas;
    }

    public Boolean getAsientosfijos() {
        return asientosfijos;
    }

    public void setAsientosfijos(Boolean asientosfijos) {
        this.asientosfijos = asientosfijos;
    }

    public int getNumerofilas() {
        return numerofilas;
    }

    public void setNumerofilas(int numerofilas) {
        this.numerofilas = numerofilas;
    }

    public int getAsientosfila() {
        return asientosfila;
    }

    public void setAsientosfila(int asientosfila) {
        this.asientosfila = asientosfila;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Usuario getUsuariocreador() {
        return usuariocreador;
    }

    public void setUsuariocreador(Usuario usuariocreador) {
        this.usuariocreador = usuariocreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Evento[ idevento=" + idevento + " ]";
    }
    
}

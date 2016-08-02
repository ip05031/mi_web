/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IPalacios
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo"),
    @NamedQuery(name = "Articulo.findByTituloa", query = "SELECT a FROM Articulo a WHERE a.tituloa = :tituloa"),
    @NamedQuery(name = "Articulo.findByAutora", query = "SELECT a FROM Articulo a WHERE a.autora = :autora"),
    @NamedQuery(name = "Articulo.findByResumena", query = "SELECT a FROM Articulo a WHERE a.resumena = :resumena"),
    @NamedQuery(name = "Articulo.findByArchivoa", query = "SELECT a FROM Articulo a WHERE a.archivoa = :archivoa")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private Integer idArticulo;
    @Size(max = 250)
    @Column(name = "tituloa")
    private String tituloa;
    @Size(max = 250)
    @Column(name = "autora")
    private String autora;
    @Size(max = 500)
    @Column(name = "resumena")
    private String resumena;
    @Size(max = 250)
    @Column(name = "archivoa")
    private String archivoa;
    @ManyToMany(mappedBy = "articuloList")
    private List<PalabraClave> palabraClaveList;
    @JoinColumn(name = "id_revista", referencedColumnName = "id_revista")
    @ManyToOne
    private Revista idRevista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private List<Descarga> descargaList;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTituloa() {
        return tituloa;
    }

    public void setTituloa(String tituloa) {
        this.tituloa = tituloa;
    }

    public String getAutora() {
        return autora;
    }

    public void setAutora(String autora) {
        this.autora = autora;
    }

    public String getResumena() {
        return resumena;
    }

    public void setResumena(String resumena) {
        this.resumena = resumena;
    }

    public String getArchivoa() {
        return archivoa;
    }

    public void setArchivoa(String archivoa) {
        this.archivoa = archivoa;
    }

    @XmlTransient
    public List<PalabraClave> getPalabraClaveList() {
        return palabraClaveList;
    }

    public void setPalabraClaveList(List<PalabraClave> palabraClaveList) {
        this.palabraClaveList = palabraClaveList;
    }

    public Revista getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(Revista idRevista) {
        this.idRevista = idRevista;
    }

    @XmlTransient
    public List<Descarga> getDescargaList() {
        return descargaList;
    }

    public void setDescargaList(List<Descarga> descargaList) {
        this.descargaList = descargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}

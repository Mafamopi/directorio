/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.datos.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author denar
 */
@Entity
@Table(name = "group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupp.findAll", query = "SELECT g FROM Groupp g"),
    @NamedQuery(name = "Groupp.findByGroupid", query = "SELECT g FROM Groupp g WHERE g.groupid = :groupid"),
    @NamedQuery(name = "Groupp.findByGroupname", query = "SELECT g FROM Groupp g WHERE g.groupname = :groupname"),
    @NamedQuery(name = "Groupp.findByGroupenable", query = "SELECT g FROM Groupp g WHERE g.groupenable = :groupenable")})
public class Groupp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupid")
    private Integer groupid;
    @Basic(optional = false)
    @Column(name = "groupname")
    private String groupname;
    @Basic(optional = false)
    @Column(name = "groupenable")
    private boolean groupenable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupid")
    private Collection<ContactGroup> contactGroupCollection;

    public Groupp() {
    }

    public Groupp(Integer groupid) {
        this.groupid = groupid;
    }

    public Groupp(Integer groupid, String groupname, boolean groupenable) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.groupenable = groupenable;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public boolean getGroupenable() {
        return groupenable;
    }

    public void setGroupenable(boolean groupenable) {
        this.groupenable = groupenable;
    }

    @XmlTransient
    public Collection<ContactGroup> getContactGroupCollection() {
        return contactGroupCollection;
    }

    public void setContactGroupCollection(Collection<ContactGroup> contactGroupCollection) {
        this.contactGroupCollection = contactGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupp)) {
            return false;
        }
        Groupp other = (Groupp) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "directorio.datos.entidades.Groupp[ groupid=" + groupid + " ]";
    }
    
}

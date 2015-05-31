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
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactid", query = "SELECT c FROM Contact c WHERE c.contactid = :contactid"),
    @NamedQuery(name = "Contact.findByContactname", query = "SELECT c FROM Contact c WHERE c.contactname = :contactname"),
    @NamedQuery(name = "Contact.findByContactphone", query = "SELECT c FROM Contact c WHERE c.contactphone = :contactphone"),
    @NamedQuery(name = "Contact.findByContactenable", query = "SELECT c FROM Contact c WHERE c.contactenable = :contactenable")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contactid")
    private Integer contactid;
    @Basic(optional = false)
    @Column(name = "contactname")
    private String contactname;
    @Column(name = "contactphone")
    private String contactphone;
    @Basic(optional = false)
    @Column(name = "contactenable")
    private boolean contactenable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactid")
    private Collection<ContactGroup> contactGroupCollection;

    public Contact() {
    }

    public Contact(Integer contactid) {
        this.contactid = contactid;
    }

    public Contact(Integer contactid, String contactname, boolean contactenable) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.contactenable = contactenable;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public boolean getContactenable() {
        return contactenable;
    }

    public void setContactenable(boolean contactenable) {
        this.contactenable = contactenable;
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
        hash += (contactid != null ? contactid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactid == null && other.contactid != null) || (this.contactid != null && !this.contactid.equals(other.contactid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "directorio.datos.entidades.Contact[ contactid=" + contactid + " ]";
    }
    
}

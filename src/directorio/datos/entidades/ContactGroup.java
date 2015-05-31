/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.datos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author denar
 */
@Entity
@Table(name = "contact_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactGroup.findAll", query = "SELECT c FROM ContactGroup c"),
    @NamedQuery(name = "ContactGroup.findByContactGroupid", query = "SELECT c FROM ContactGroup c WHERE c.contactGroupid = :contactGroupid")})
public class ContactGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_groupid")
    private Integer contactGroupid;
    @JoinColumn(name = "groupid", referencedColumnName = "groupid")
    @ManyToOne(optional = false)
    private Groupp groupid;
    @JoinColumn(name = "contactid", referencedColumnName = "contactid")
    @ManyToOne(optional = false)
    private Contact contactid;

    public ContactGroup() {
    }

    public ContactGroup(Integer contactGroupid) {
        this.contactGroupid = contactGroupid;
    }

    public Integer getContactGroupid() {
        return contactGroupid;
    }

    public void setContactGroupid(Integer contactGroupid) {
        this.contactGroupid = contactGroupid;
    }

    public Groupp getGroupid() {
        return groupid;
    }

    public void setGroupid(Groupp groupid) {
        this.groupid = groupid;
    }

    public Contact getContactid() {
        return contactid;
    }

    public void setContactid(Contact contactid) {
        this.contactid = contactid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactGroupid != null ? contactGroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactGroup)) {
            return false;
        }
        ContactGroup other = (ContactGroup) object;
        if ((this.contactGroupid == null && other.contactGroupid != null) || (this.contactGroupid != null && !this.contactGroupid.equals(other.contactGroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "directorio.datos.entidades.ContactGroup[ contactGroupid=" + contactGroupid + " ]";
    }
    
}

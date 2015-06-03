/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.cotroller.dto;

/**
 *
 * @author denar
 */
public class ContactDTO {
    private String contactname;
    private Integer contactid;
    private String contacphone;
    private boolean contactenable;
    
    
    public String getContactname() {
        return contactname;
    }

    
    
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public boolean isContactenable() {
        return contactenable;
    }

    public void setContactenable(boolean contactenable) {
        this.contactenable = contactenable;
    }

    public String getContacphone() {
        return contacphone;
    }

    public void setContacphone(String contacphone) {
        this.contacphone = contacphone;
    }   
}
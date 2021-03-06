/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.cotroller;

import directorio.cotroller.dto.ContactDTO;
import directorio.datos.dao.DirectorioDAO;
import directorio.datos.entidades.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denar
 */
public class DirectorioController {
    private static DirectorioController directorioController = null;
    final private static DirectorioDAO dao = DirectorioDAO.getDirectorioDAO();
    
    private DirectorioController()
    {
        
    }
    
    public static DirectorioController getDirectorioController()
    {
        if(DirectorioController.directorioController == null)
        {
            DirectorioController.directorioController = new DirectorioController();
        }
        return DirectorioController.directorioController;
    }
    
    public List<ContactDTO> getAllContacts()
    {
        List<Contact> contactEntities =  dao.getAllContacts();
        return convertListDao2Dto(contactEntities);
    }
    
    public List<ContactDTO> getActiveContacts()
    {
        List<Contact> contactEntities =  dao.getActiveContacts();
        return convertListDao2Dto(contactEntities);
    }
    
    public List<ContactDTO> getInactiveContacts()
    {
        List<Contact> contactEntities =  dao.getInactiveContacts();
        return convertListDao2Dto(contactEntities);
    }
    
    private List<ContactDTO> convertListDao2Dto(List<Contact> contactEntities){
        List<ContactDTO> contacts = new ArrayList<ContactDTO>();
        for(Contact contact : contactEntities)
        {
            ContactDTO c = new ContactDTO();
            c.setContactname(contact.getContactname());
            c.setContactid(contact.getContactid());
            c.setContactenable(contact.getContactenable());
            c.setContacphone(contact.getContactphone());
            contacts.add(c);
        }
        return contacts;
    }
    
    public List<ContactDTO> findContactByCharName(String charName){
        List<Contact> contacts = dao.findContactsByCharName(charName);
        return convertListDao2Dto(contacts);
    }
    
    public void setContactAsInactive(ContactDTO contact) throws Exception{
        contact.setContactenable(false);
        this.editContact(contact);
    }
    
    public void setContactAsActive(List<ContactDTO> contacts) throws Exception{     
        List<Contact> contactEntities = new ArrayList<Contact>();
        for(ContactDTO dto : contacts){
            Contact contact = new Contact();
            contact.setContactenable(true);
            contact.setContactid(dto.getContactid());
            contact.setContactname(dto.getContactname());
            contact.setContactphone(dto.getContacphone());
            contactEntities.add(contact);
        }
        dao.setContactsAsActive(contactEntities);
    }

    public void addContact(ContactDTO obj) throws Exception {
        Contact contact = new Contact();
        contact.setContactname(obj.getContactname());
        contact.setContactenable(true);
        contact.setContactphone(obj.getContacphone());
        dao.addContact(contact);
    }
    
    public void editContact(ContactDTO obj) throws Exception {
        Contact contact = new Contact();
        contact.setContactid(obj.getContactid());
        contact.setContactname(obj.getContactname());
        contact.setContactenable(obj.isContactenable());
        contact.setContactphone(obj.getContacphone());
        dao.editContact(contact);
    }
    public boolean contactNameExists(String contactName) throws Exception
    {
       return dao.contactNameExists(contactName);
    }
}

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
}

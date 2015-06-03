/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.datos.dao;

import directorio.datos.entidades.Contact;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author denar
 */
public class DirectorioDAO {
    final private static EntityManager em = Persistence.createEntityManagerFactory("directorioPU").createEntityManager();
    private static DirectorioDAO directorioDAO = null;
    
    private DirectorioDAO()
    {
        
    }
    
    public static DirectorioDAO getDirectorioDAO()
    {
        if(DirectorioDAO.directorioDAO == null)
        {
            DirectorioDAO.directorioDAO = new DirectorioDAO();
        }
        return DirectorioDAO.directorioDAO;
    }  
    
    public void addContact(Contact nuevo) throws Exception {
        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
        em.close();
    }
    
    public void editContact(Contact existe) throws Exception {
        em.getTransaction().begin();
        em.merge(existe);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Contact> getAllContacts()
    {
        Query query = em.createQuery("SELECT c FROM Contact c");
        return (List<Contact>) query.getResultList();
    }
}

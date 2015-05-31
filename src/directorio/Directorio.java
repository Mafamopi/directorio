/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import directorio.cotroller.DirectorioController;
import directorio.cotroller.dto.ContactDTO;
import directorio.mensajes.Messages;

/**
 *
 * @author denar
 */
public class Directorio {
    
    final static String CONFIGURATION_FILE_PATH = "directorio.mensajes.congig";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PRUEBA TRAER TODOS LOS CONTACTOS
        DirectorioController controller = DirectorioController.getDirectorioController();
        Messages msg = Messages.getMessagesRetriever();
        for(ContactDTO contact : controller.getAllContacts())
        {
            System.out.println(msg.getMessage("test.message") + contact.getContactid() + " " + contact.getContactname());
        }
    }
    
}

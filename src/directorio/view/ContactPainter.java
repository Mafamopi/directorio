package directorio.view;

import directorio.cotroller.dto.ContactDTO;
import java.util.List;
import javax.swing.JPanel;

public class ContactPainter {
    
    public void paintContacts(JPanel panel,List<ContactDTO> contactList,String filtro){
        for(ContactDTO contacts:contactList){
            //TODO: crear logica para filtrar el nombre
        }
    }
}

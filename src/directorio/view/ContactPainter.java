package directorio.view;

import directorio.cotroller.dto.ContactDTO;
import java.util.List;
import javax.swing.JPanel;

public class ContactPainter {

    MainScreen _mainScreen;
    public ContactPainter(MainScreen main) {
        _mainScreen = main;
    }
    
    public void buildContactList(JPanel panel,List<ContactDTO> contactList){
        _mainScreen.paintList(panel,contactList);
    }
    
    public void paintContacts(JPanel panel,List<ContactDTO> contactList,String filtro){
        for(ContactDTO contacts:contactList){
            //TODO: crear logica para filtrar el nombre
        }
    }
}

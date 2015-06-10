package directorio.view;

import directorio.cotroller.DirectorioController;
import directorio.cotroller.dto.ContactDTO;
import directorio.mensajes.Messages;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContactPainter {
    DirectorioController _controller = DirectorioController.getDirectorioController();
    MainScreen _main;
    Messages msg = Messages.getMessagesRetriever();
    public ContactPainter(MainScreen main) {
        _main = main;
    }
    
    public void buildContactList(JPanel panel,List<ContactDTO> contactList){
//        _mainScreen.paintList(panel,contactList);
        int y =0;
        panel.removeAll();
        if(contactList == null || contactList.isEmpty()){
            contactList = _controller.getActiveContacts();
        }
        
        for(ContactDTO contact : contactList){
            javax.swing.JLabel name = new JLabel();
            javax.swing.JLabel phone = new JLabel();
            javax.swing.JButton btnUpdate = new JButton();
            javax.swing.JButton btnEnable = new JButton();
            
            name.setText(contact.getContactname());
            phone.setText(contact.getContacphone());
            btnUpdate.setText(msg.getMessage("MainScren.button"));
            btnEnable.setText(msg.getMessage("MainScren.button.enable"));
           // btnUpdate.setModel(jButton1.getModel());
                    
            name.setLocation(0, y);
            phone.setLocation(150,y);
            btnUpdate.setLocation(250, y);
            btnEnable.setLocation(350, y);
            
            name.setSize(200,20);
            phone.setSize(100,20);
            btnUpdate.setSize(100, 20);
            btnEnable.setSize(100, 20);
            
            name.setVisible(true);
            phone.setVisible(true);
            btnUpdate.setVisible(true);
            
            panel.add(btnUpdate);
            panel.add(name);
            panel.add(phone);
            panel.add(btnEnable);
            y=y+20;       
            //Agrega el evento al botón update
            addEditEvent(btnUpdate, contact);
            addDisableEvent(btnEnable, contact);
        }
    }
    
     private void addEditEvent(JButton updateButton, final ContactDTO contact)
    {
        
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                final CreateEdit createEdit = new CreateEdit(_main);
                createEdit.setIsUpdate(true);
                createEdit.setContact(contact);
                createEdit.refreshContactForm();
                _main.setEnabled(false);
            }
        });
    }
    
    private void addDisableEvent(JButton enableButton, final ContactDTO contact){
        
        enableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                
                try {                   
                    contact.setContactenable(false);
                    _controller.setContactAsInactive(contact);
                    buildContactList(_main.getjPanel2(), null);
                    _main.update(_main.getGraphics());
                } catch (Exception e) {
                    
                }
            }
        });
    }
    
    public void paintContacts(JPanel panel,List<ContactDTO> contactList,String filtro){
        List<ContactDTO> contactListFilter = this.getFilteredContacts(contactList, filtro);
        if(!contactListFilter.isEmpty()){
            buildContactList(panel,contactListFilter);
            
        }else{
            panel.removeAll();
            JLabel label = new JLabel();
            label.setText(msg.getMessage("message.search.null"));
            label.setLocation(0,0);
            label.setSize(200,20);
            label.setVisible(true);
            panel.add(label);
        }
        _main.repaint();
    }
    
    public List<ContactDTO> getFilteredContacts(List<ContactDTO> contactList,String filtro){
        List<ContactDTO> contactListFilter = new ArrayList<ContactDTO>();
        if(filtro==null || "".equals(filtro.trim())){
            return contactList;
        }else{
            for(ContactDTO contact:contactList){
                if(contact.getContactname().toLowerCase().contains(filtro.toLowerCase())){
                contactListFilter.add(contact);
                }
            }
            return contactListFilter;
        }
    }
}

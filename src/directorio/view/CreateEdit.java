/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.view;

import directorio.cotroller.DirectorioController;
import directorio.cotroller.dto.ContactDTO;
import directorio.mensajes.Messages;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author caliche
 */
public class CreateEdit extends javax.swing.JFrame {

    Messages msg = Messages.getMessagesRetriever();
    private boolean isUpdate = false;
    private ContactDTO contact = null;
    MainScreen _main;

    /**
     * ut Creates new form crear
     */
    public CreateEdit(MainScreen main) {

        initComponents();
        _main = main;
        lbCreateName.setText(msg.getMessage("create.label.name"));
        lbCrearTelefono.setText(msg.getMessage("create.label.phone"));
        btnGrabar.setLabel(msg.getMessage("create.label.add"));
        btnCrearCancelar.setLabel(msg.getMessage("create.label.cancel"));

        this.setVisible(true);

        contact = new ContactDTO();
        center();
        this.setAlwaysOnTop(true);
    }

    public void refreshContactForm() {
        txtCrearNombre.setText(contact.getContactname());
        txtCrearTelefono.setText(contact.getContacphone());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCreateName = new java.awt.Label();
        lbCrearTelefono = new java.awt.Label();
        txtCrearNombre = new java.awt.TextField();
        txtCrearTelefono = new java.awt.TextField();
        btnGrabar = new java.awt.Button();
        btnCrearCancelar = new java.awt.Button();

        setMinimumSize(new java.awt.Dimension(300, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbCreateName.setMinimumSize(new java.awt.Dimension(200, 200));
        lbCreateName.setText("Nombre");

        lbCrearTelefono.setText("Telefono");

        btnGrabar.setLabel("Grabar");
        btnGrabar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGrabarMouseClicked(evt);
            }
        });

        btnCrearCancelar.setLabel("Cancelar");
        btnCrearCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearCancelarMouseClicked(evt);
            }
        });
        btnCrearCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCreateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtCrearNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCrearTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtCrearTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCrearCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCreateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCrearNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCrearTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCrearTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearCancelarActionPerformed

    private void btnGrabarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGrabarMouseClicked
        try {
            //Asi conseguimos el name y se lo colocamos al objeto DTO para guardarlo
            String name = txtCrearNombre.getText();
            String phone = txtCrearTelefono.getText();
            if(name.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.validation.name.error"));
                return;
            }
            if(phone.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.validation.phone.error"));
                return;
            }
            
            //Aqui llamo al controlador para guardar el contacto
            DirectorioController controller = DirectorioController.getDirectorioController();

            int sizeName = name.length();
            if (name.trim().equals(contact.getContactname().trim()) || !controller.contactNameExists(name)) {
                contact.setContactname(name);
                contact.setContacphone(phone);
                if (sizeName < 49) {
                    if (isUpdate) {
                        controller.editContact(contact);
                        JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.edit"));
                    } else {
                        controller.addContact(contact);
                        JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.success"));
                    }
                    _main.paintList();
                    
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.sizename"));
                }
            } else {
                JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.exist"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msg.getMessage("message.addcontact.error"));
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGrabarMouseClicked

    private void btnCrearCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCancelarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearCancelarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        _main.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        _main.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void center()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    public boolean isIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCrearCancelar;
    private java.awt.Button btnGrabar;
    private java.awt.Label lbCrearTelefono;
    private java.awt.Label lbCreateName;
    private java.awt.TextField txtCrearNombre;
    private java.awt.TextField txtCrearTelefono;
    // End of variables declaration//GEN-END:variables
}

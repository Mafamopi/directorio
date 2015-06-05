/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.mensajes;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author denar
 */
public class Messages {
    
    final private ResourceBundle resourceBundle;
    public static String language;
    final private static String MESSAGES_SPANISH = "directorio.mensajes.application_es";
    final private static String MESSAGES_ENGLISH = "directorio.mensajes.application_en";
    
    private Messages()
    {
        resourceBundle = PropertyResourceBundle.getBundle(MESSAGES_SPANISH);
    }
    
    private Messages(String messagesFilePath)
    {
        resourceBundle = PropertyResourceBundle.getBundle(messagesFilePath);
    }
    
    public static Messages getMessagesRetriever()
    {
        
        String lastChosenLanguage = getLastChosenLanguage();
        return Messages.getMessagesRetriever(lastChosenLanguage);
    }
   
    private static String getLastChosenLanguage()
    {
        //Aquí se debe implementar la verificación del último idioma seleccionado
        //por el usuario. Por ahora se coloca "es" mientras el método se implementa.
        if("Inglés".equals(language) || "English".equals(language)){
            return "en";
        }
        return "es";
    }
    
    /**
     * Recibe un String con el idioma y regresa un objeto de mensajes.
     * es para ESPAÑOL
     * en para INGLÉS
     * 
     * El idioma por defecto es Español
     * @param language
     * @return 
     */
    public static Messages getMessagesRetriever(String language)
    {
        if(language.trim().equalsIgnoreCase("en"))
        {
            return new Messages(MESSAGES_ENGLISH);
        }
        return new Messages();
    }
    
    public String getMessage(String key)
    {
        
        return resourceBundle.getString(key);
        
    }
    
}

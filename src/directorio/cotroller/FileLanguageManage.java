/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.cotroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author caldep
 */
public class FileLanguageManage {
    File file;
    

    public FileLanguageManage(String path) throws IOException {
        this.file = new File(path);
        if(!file.exists()){
            FileWriter writeFile = new FileWriter(file);
            writeFile.close();
        }
    }
    
     
    public String getPath() {
        return this.file.getPath();
    }

    public String getLanguage() throws FileNotFoundException, IOException {
        String line="";
        if(file.exists()){
            FileReader readFile = new FileReader(file);
            BufferedReader buffer = new BufferedReader(readFile);
            line = buffer.readLine();
            readFile.close();
        }
        return line;
    }


    public void setLanguage(String line) throws IOException {
        FileWriter writeFile = new FileWriter(file);
        PrintWriter writer = new PrintWriter(writeFile);
        writer.println(line);
        writeFile.close();
    }
    
    
        
        
    
    
}

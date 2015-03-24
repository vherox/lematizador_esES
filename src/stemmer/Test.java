/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stemmer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Verónica Santamaría
 */
public class Test {
  
    public static void main(String[] args) {
        
        FileInputStream fis = null;
        try {
            File affFile = new File("es_ES.aff"); 
            InputStream aff = new FileInputStream(affFile);
            File dicFile = new File("es_ES.dic");
            InputStream dic = new FileInputStream(dicFile);
            Dictionary dictionary = new Dictionary (aff, dic);
            
            Stemmer stemmer = new Stemmer(dictionary);
            System.out.println(stemmer.stem("tenía"));
            System.out.println(stemmer.stem("cosas"));
            System.out.println(stemmer.stem("comas"));
            System.out.println(stemmer.stem("préstamos"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
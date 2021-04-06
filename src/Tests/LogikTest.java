/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Fachlogik.Artikel;
import Fachlogik.ArtikelFactory;
import Fachlogik.Artikelverwaltung;
import Fachlogik.myArtikelFactory;
import GUI.Controller;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import junit.framework.TestCase;

/**
 *
 * @author maric010
 */
public class LogikTest extends TestCase {
    
    private final ArtikelFactory av ;
     
  
    public LogikTest(String name){
        super(name);
          av = new myArtikelFactory();
          
          
    }
    
    public void testArtikel(){
          String[] values = new String[11];
            values[0] = "123";
            values[1] = "test1";
            values[2] = "test2";
            values[3] = "test3";
            values[4] = "22";
            values[5] = "test5";
            values[6] = "test6";
            values[7] = "12.22";
            values[8] = "test8";
            values[9] = "13";
            values[10] = "true";
        
        
        
         
         
        Artikel testArtikel = av.erzeugeElement("BUCH", values);
          
        assertTrue(22 == testArtikel.getErscheinungsjahr());
        
       
    }
}

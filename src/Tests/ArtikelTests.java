/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Fachlogik.Artikel;
import Fachlogik.Buch;
import junit.framework.TestCase;
//import org.junit.Test;

/**
 *
 * @author maric010
 */
public class ArtikelTests extends TestCase {
    
    
    public ArtikelTests(String name){
        super(name);
    }
    
    public void testPreis(){
        Artikel a = new Buch("12", "testtitle", "myautor", "einverlag", 1992, "deutsch", "mygenre", 12.00,"taschenbuch", 122, false);
        assertTrue(12.00 == a.getPreis());
    }
    
    public void testErschjahr(){
         Artikel a = new Buch("12", "testtitle", "myautor", "einverlag", 1992, "deutsch", "mygenre", 12.00,"taschenbuch", 122, false);
         assertTrue(1992 == a.getErscheinungsjahr());
    }
    
}

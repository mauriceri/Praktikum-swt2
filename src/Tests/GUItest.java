/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Fachlogik.Artikel;
import Fachlogik.Buch;
import GUI.Controller;
import Fachlogik.Artikelverwaltung;
import javafx.application.Application;
import javafx.stage.Stage;
import junit.framework.TestCase;


/**
 *
 * @author maric010
 */
public class GUItest extends TestCase{

    Controller controller;
    Artikelverwaltung artikelverwaltung;

    public GUItest(String name){
        super(name);

        controller = new Controller();
        artikelverwaltung = Artikelverwaltung.getInstance(controller);
    }


    public void testPriceChange(){

        Artikel a = new Buch("123", "testname", "testautor", "myVerlag", 1992, "testSprache", "einGenre", 42.42, "Cover", 123, true);


        artikelverwaltung.addArtikelListe(a);
        controller.zumWarenkorb("123");

        assertTrue(controller.gesamtPreisAnzeigen() == 42.42);

       // System.out.println(controller.gesamtPreisAnzeigen() == 42.42);

    }
    
}

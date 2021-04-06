/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachlogik;

import Log.MyLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author maric010
 */
public class Katalog implements Serializable {
    
    private Logger log = MyLogger.getInstance().getLogger();
    
    private ArrayList<Artikel> artikelList;
    
    
    public Katalog(){
        
        artikelList = new ArrayList();
        
    }
    
    /**
     * Fügt Artikel zum Katalog hinzu 
     * @param artikel Artikel
     */
    
    public void addArtikel(Artikel artikel){
        artikelList.add(artikel);
        
        log.info("Artikel "+ artikel.getArtikelNummer() + " im Katalog");
        
       zeigeKatalogArtikel();
    }
    /**
     * Ausgabe des Kataloges auf Konsole
     */
    void zeigeKatalogArtikel(){
        artikelList.forEach(System.out::println);
    }
}

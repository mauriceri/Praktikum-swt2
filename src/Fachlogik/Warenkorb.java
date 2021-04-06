package Fachlogik;

import Log.MyLogger;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


public class Warenkorb {
    
    private Logger log = MyLogger.getInstance().getLogger();

    private double gesamtpreis;
    private int artikelanzahl;
    
    private Artikelverwaltung artikelverwaltung;

    private List<Artikel> artikelListe = new LinkedList();
    
    public Warenkorb(Artikelverwaltung artikelverwaltung){
        this.artikelverwaltung = artikelverwaltung;
    }
    
    
    
    /**
     * Berechnet den gesamt-preis des Warenkorbes
     * @return Gibt summe des Warenkorbes zurück
     */
    
    public double preisBerechnen(){
        double summe = 0.0;

        for (Artikel artikel : artikelListe) {
            summe = summe + artikel.getPreis();
        }     
        summe = summe * 100;
        summe = Math.round(summe);
        summe = summe / 100;    
        return summe;
    }
 
 
    /**
     * Fügt Artikel zu Warenkorb hinzu
     * @param a Artikel Objekt
     */
    
    public void artikelHinzufuegen(Artikel a){ 
        boolean test = artikelverwaltung.istVorhanden(a);
        
        if(test) {
            
            artikelListe.add(a);
            artikelanzahl++;

        }
        
        log.info("Artikel " + a.getArtikelNummer() + " wurde zum Warenkorb hinzugefügt");
        
        
    }
    
    /**
     * Löscht artikel aus liste
     * @param art Artikel
     */
    
    public void artikelLoeschen(Artikel art) {

        artikelListe.remove(art);
        artikelanzahl--;
        
        log.info("Artikel "+ art.getArtikelNummer()  + "aus Warenkorb geloescht");
    }
    
    /**
     * Artikel bezahlen 
     */
    
    public void zurKasseGehen(){
        new Kasse().bezahlen(artikelListe);
        
        log.info("Zur Kasse");
    }
    
    
  }


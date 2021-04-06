package Fachlogik;

import Datenhaltung.IDAO;
import Datenhaltung.KundeDAO;
import GUI.Controller;
import Log.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Kundenverwaltung {

    
    private Logger log = MyLogger.getInstance().getLogger();
    
    private List<Kunde> kundenListe = new ArrayList<>();
    private IDAO dao;
    
    
    private boolean isSaved = false;
    private boolean isLoaded = false;
    
    private Controller controller;
    
    //singleton pattern anfang
    public static Kundenverwaltung instance;
    
    public static Kundenverwaltung getInstance(Controller controller){
        
        if(instance == null){
            instance = new Kundenverwaltung(controller);
        }
        
        return instance;
    }

    private Kundenverwaltung(Controller controller) {
        this.dao = new KundeDAO();
        this.controller = controller;
    }
    //singleton ende

    /**
     * Nimmt ein Kunde auf und speichert ihn in die Datenbank über das Dao 
     * @param neuerKunde Kunde der aufgenommen werden soll
     */
    
    public void aufnehmen(Kunde neuerKunde) {
        kundenListe.add(neuerKunde);
        dao.speicher(neuerKunde);
        
        log.info("Neuer Kunde "+ neuerKunde.getId());
    }

    /**
     * sucht Kunde anhand der Id aus der Liste raus und gibt ihm zurueck
     * @param id Kundenummer
     * @return Kunde passend zur Kundenummer
     */
    
    public Kunde findeKunde(int id){
        for(Kunde k: kundenListe){
            if(k.getId() == id){
                return k;
            }
        }
        
        log.info(("Nach Kunde " + id + " gesucht"));
        
        return null;
    }

    /**
     * Loescht ein kunde aus der Liste anahnd der ID
     * @param kundenID Kundenummer
     */
    
    public void loeschen(Kunde kundenID) {
        
        kundenListe.remove(kundenID);
        log.info("Kunde "+ kundenID.getId() + " entfernt");
    }

    /**
     * Loescht komplette kundeliste
     */
    
    public void alleKundenLoeschen() {
        kundenListe.clear();
        log.info("Ganze Kundenliste  gelöscht");
    }

    /**
     * Speichert liste in die Datenbank über das Dao
     */
    
    public void speichern() {
        if(isSaved == false){
            dao.speicherListe(kundenListe);
            log.info("Kundeliste gespeichert");
        }
    }

    /**
     * Lädt komplette kundelist über das Dao        
     */
    
    public void laden() {
        if (!isLoaded) {
            kundenListe.clear();
            kundenListe = dao.laden();
            isLoaded = true;
            
            log.info("Kundenliste geladen");
        }

        
    }

    public List<Kunde> getKundenListe() {
        return kundenListe;
    }
    

    public Iterator<Kunde> iterator() {
        return kundenListe.iterator();
    }
    
    public List<Kunde> getKundeList(){
        return kundenListe;
    }

}

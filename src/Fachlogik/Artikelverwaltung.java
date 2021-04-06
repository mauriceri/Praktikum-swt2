package Fachlogik;

import Datenhaltung.ArtikelDAO;
import Datenhaltung.IDAO;
import GUI.Controller;
import Log.MyLogger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Artikelverwaltung {

    private final IDAO dao;
    private final ArtikelFactory factory = new myArtikelFactory();

    private boolean isSaved = false;
    private boolean isLoaded = false;

    private Logger log = MyLogger.getInstance().getLogger();

    //singleton pattern anfang
    private static Artikelverwaltung instance;

    public static Artikelverwaltung getInstance(Controller controller) {
        if (instance == null) {
            instance = new Artikelverwaltung(controller);
        }

        return instance;
    }

    //singleton ende
    private List<Artikel> artikelListe = new ArrayList<Artikel>();

    private Controller controller;

    private Artikelverwaltung(Controller controller) {
        this.dao = new ArtikelDAO();
        this.controller = controller;
    }

    /**
     * nimmt ein Objekt vom Typ Artikel auf mithilfe einer Artikel-Factory
     * @param typ Artikel-Typ 
     * @param neuerArtikel Werte der Attribute des Artikels
     */
    public void aufnehmen(String typ, String[] neuerArtikel) {
        Artikel a = factory.erzeugeElement(typ, neuerArtikel);
        artikelListe.add(a);
        dao.speicher(a);
        controller.updateObl();

        log.info("Artikel " + a.getArtikelNummer() + " hinzugefuegt");

    }

    /**
     * loescht artikel anhand der Artikelnummer aus der artikelliste  
     * @param artikelnummer Artikelnummer
     */
    public void loescheArtikel(String artikelnummer) {

        Artikel rm = null;
        for (Artikel a : artikelListe) {
            if (a.getArtikelNummer().equals(artikelnummer)) {
                rm = a;
                break;
            }
        }
        artikelListe.remove(rm);

        log.info("Artikel mit Nummer" + rm.getArtikelNummer() + " entfernt");

    }

    
    /**
     * prueft ob ein Artikel in der Artikelliste vorhanden ist
     * @param a Artikel
     * @return Gibt True wenn vorhanden, ansonsten False
     */
    
    public boolean istVorhanden(Artikel a) {

        boolean vorhanden = false;

        for (Artikel art : artikelListe) {
            if (a.equals(art)) {
                vorhanden = true;
            }
        }
        return vorhanden;

    }

   
   
    public Iterator<Artikel> iterator() {
        return artikelListe.iterator();
    }

    /**
     * speichert die Artikelliste über das Dao in die Datenbank
     */
   
    public void speichern() {

        if (!isSaved) {
            dao.speicherListe(artikelListe);
            isSaved = true;
            log.info("Artikelliste gespeichert");
        }
    }

    /**
     * Lädt Artikelliste
     */
    public void laden() {
        artikelListe.clear();
        artikelListe = dao.laden();
        if (!isLoaded) {
            isLoaded = true;
        }

        log.info("Artikelliste geladen");
    }

    /**
     * filtert alle buecher aus der Artikelliste und gibt sie zurueck
     * @return Gibt Buchliste zurück 
     */
   
    public List<Buch> getBuchList() {
        List<Buch> list = new ArrayList<>();
        for (Artikel a : artikelListe) {
            if (a instanceof Buch) {
                Artikel b1 = a;
                list.add((Buch) b1);
            }
        }
        return list;
    }

    /**
     * filtert alle Hoerbuecher aus der Artikelliste und gibt sie zurueck
     * @return  Gibt Hoerbuchliste zurück
     */
    
    public List<Hoerbuch> getHoeruchList() {
        List<Hoerbuch> list = new ArrayList<>();
        for (Artikel a : artikelListe) {
            if (a instanceof Hoerbuch) {
                Artikel b1 = a;
                list.add((Hoerbuch) b1);
            }
        }
        return list;
    }

    /**
     * Sucht den Artikel aus der Liste anhand der Nummer raus
     * @param nummer Artikelnummer
     * @return Gibt Artikel zur Artikelnummer zurück
     */
    //
    public Artikel sucheNummer(String nummer) {

        for (Artikel a : artikelListe) {
            if (a.getArtikelNummer().equals(nummer) || a.getTitel().equals(nummer)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Aktualisiert den Preis zum Artikel
     * @param artikel Artikel
     * @param newPreis Neuer Preis des Artikels
     */
    public void updatePreis(Artikel artikel, double newPreis) {

        for (Artikel a : artikelListe) {
            if (a == artikel) {
                a.setPreis(newPreis);
                log.info("Preisänderung Artikel " + a.getArtikelNummer() + " zu " + a.getPreis());
            }
        }
        controller.updateObl();
    }

    //getter setter
    public List<Artikel> getArtikelListe() {
        return artikelListe;
    }

    public Artikel getIndexArtikel(int i) {
        return artikelListe.get(i);
    }

    public List<Artikel> getKatalogList() {

        ArrayList<Artikel> al = new ArrayList();

        for (Artikel a : artikelListe) {
            if (true == a.getIsKatalog()) {
                al.add(a);
            }
        }
        return al;
    }

    //Methode für JUnit tests
    public void addArtikelListe(Artikel a) {
        artikelListe.add(a);
    }

}

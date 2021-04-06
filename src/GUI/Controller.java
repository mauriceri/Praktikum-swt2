/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.*;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


public class Controller {

    private Artikelverwaltung artikelverwaltung;
    private Kundenverwaltung kundenverwaltung;

    private Warenkorb warenkorb;

    private ObservableList obl;

    private ObservableList<Buch> obl_buch = FXCollections.observableArrayList();
    private ObservableList<Hoerbuch> obl_hoerbuch = FXCollections.observableArrayList();
    private ObservableList<Kunde> obl_kunde = FXCollections.observableArrayList();
    private ObservableList<Artikel> warenKorbList = FXCollections.observableArrayList();
    private ObservableList<Artikel> katalogList = FXCollections.observableArrayList();



    public Controller() {

        this.artikelverwaltung = Artikelverwaltung.getInstance(this);
        this.kundenverwaltung = Kundenverwaltung.getInstance(this);
        this.warenkorb = new Warenkorb(artikelverwaltung);
    }


    //entfernt Artikel aus der Verwaltung
    void removeArtikel(String nummer) {

        Artikel a = artikelverwaltung.sucheNummer(nummer);

        try {

            if (a.equals(null)) {
                throw new NullPointerException("Object ist null");
            }

            artikelverwaltung.loescheArtikel(a.getArtikelNummer());

            if (a instanceof Buch) {
                obl_buch.remove(a);
            } else {
                obl_hoerbuch.remove(a);
            }

            obl.remove(a);
        } catch (NullPointerException e) {
            MessageView.create(new Stage(), "Fehler", "Artikel nicht Vorhanden").showView();
        }

    }

    
     //entfernt Kunde aus der Verwaltung
    void removeKunde(int id) {
        Kunde k = kundenverwaltung.findeKunde(id);

        try {
            if (k.equals(null)) {
                throw new NullPointerException("Object ist null");
            }


            kundenverwaltung.loeschen(k);
            obl_kunde.remove(k);
            obl.remove(k);
        } catch (NullPointerException e) {
            MessageView.create(new Stage(), "Fehler", "Kunde nicht Vorhanden").showView();
        }
    }

   

    //legt neuen Kunde in der verwaltung an
    void newKunde(Kunde kunde) {
        kundenverwaltung.aufnehmen(kunde);
        obl.add(kunde);
        obl_kunde.add(kunde);
    }

    //legt neuen Artikel in der verwaltung an
    void newArtikel(String typ, String[] values) {
        artikelverwaltung.aufnehmen(typ, values);
        
    }

    //ruft speicher-methoden in der Verwaltung auf
    void save() {
        artikelverwaltung.speichern();
        kundenverwaltung.speichern();
    }

    
    //aktualisiert die Observerable list
    public void updateObl() {

        obl.clear();
        obl_kunde.clear();
        obl_hoerbuch.clear();
        obl_buch.clear();
        katalogList.clear();
        
        obl.addAll(artikelverwaltung.getArtikelListe());
        obl.addAll(kundenverwaltung.getKundenListe());
        
        obl_kunde.addAll(kundenverwaltung.getKundeList());
        obl_hoerbuch.addAll(artikelverwaltung.getHoeruchList());
        obl_buch.addAll(artikelverwaltung.getBuchList());
        katalogList.addAll(artikelverwaltung.getKatalogList());
    }


    //laedt Daten aus den verwaltungsklassen
    void load() {

        artikelverwaltung.laden();
        kundenverwaltung.laden();
        
        updateObl();
   
        
    }

    //laedt die Artikel fuer die Kundenansicht
    public void kundeViewLoad() {

        artikelverwaltung.laden();
        warenKorbList.addAll(artikelverwaltung.getArtikelListe());

    }


    //aktualisiert Preis fuer Artikel
    void preisChange(Double newValue, Artikel a) {
        artikelverwaltung.updatePreis(a, newValue);
    }

    //KundeView <------------------------------------------>
    public double gesamtPreisAnzeigen() {
        return warenkorb.preisBerechnen();
    }


    
    //fuegt artikel zum warenkorb hinzu
    public void zumWarenkorb(String nummer) {
        try {
            Artikel a = artikelverwaltung.sucheNummer(nummer);

            if (a.equals(null)) {
                throw new NullPointerException("Object ist null");
            }
            warenkorb.artikelHinzufuegen(a);
            warenKorbList.add(a);

        } catch (NullPointerException e) {
            MessageView.create(new Stage(), "Fehler", "Artikel nicht Vorhanden").showView();
        }

    }

    //loescht artikel aus Warenkorb anhand der Artikelnummer
    void artikelLoeschen(String nummer) {

        try {

            Artikel a = artikelverwaltung.sucheNummer(nummer);

            if (a.equals(null)) {
                throw new NullPointerException("Object ist null");
            }

            warenkorb.artikelLoeschen(a);
            warenKorbList.remove(a);

        } catch (NullPointerException e) {
            MessageView.create(new Stage(), "Fehler", "Artikel nicht Vorhanden").showView();
        }

    }

   
    
    //getter setter
    void setWarenkorbObl(ObservableList obl) {
        this.warenKorbList = obl;
    }

    
    
    public ObservableList<Artikel> getKatalogList() {
        return katalogList;
    }

    

    ObservableList<Buch> getBuchList() {
        return obl_buch;
    }

    ObservableList<Hoerbuch> getHoerbuchList() {
        return obl_hoerbuch;
    }

    ObservableList<Kunde> getKundenList() {
        return obl_kunde;
    }

    
    public void setObl(ObservableList obl) {
        this.obl = obl;
    }

    

}

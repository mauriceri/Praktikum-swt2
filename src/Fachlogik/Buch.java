package Fachlogik;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Buch extends Artikel  {

    String art;
    int seitenanzahl;

    public Buch() {
        super();
    }

    public Buch(String artikelNummer, String titel, String author, String verlag, int erscheinungsjahr, String sprache, String genre, double preis, String art, int seitenanzahl,  boolean addKatalog) {
        super(artikelNummer, titel, author, verlag, erscheinungsjahr, sprache, genre, preis, addKatalog );
        this.art = art;
        this.seitenanzahl = seitenanzahl;

    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getSeitenanzahl() {
        return seitenanzahl;
    }

    public void setSeitenanzahl(int seitenanzahl) {
        this.seitenanzahl = seitenanzahl;
    }

    public String toString() {
        return ("Buch: " + " Artikelnummer: " + this.getArtikelNummer() + " \"" + this.getTitel() + "\" von " + this.getAuthor() + " vom " + this.getVerlag() + " Verlag " + " erschienen im Jahre: " + this.getErscheinungsjahr() + " in der Sprache " + this.getSprache() + "des Genres: " + this.getGenre() + " kostet " + this.getPreis() + " Euro" + " " + this.getArt() + " Art: " + " Seitenanzahl: " + this.getSeitenanzahl());
    }



}

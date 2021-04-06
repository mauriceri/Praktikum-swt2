package Fachlogik;


import java.io.OutputStream;
import java.io.PrintWriter;

public class Hoerbuch extends Artikel {

    String format;
    int dauer;

    public Hoerbuch() {
        super();
    }

    public Hoerbuch(String artikelNummer, String titel, String author, String verlag, int escheinungsjahr, String sprache, String genre, double preis, String format, int dauer,  boolean addKatalog) {
        super(artikelNummer, titel, author, verlag, escheinungsjahr, sprache, genre, preis, addKatalog);
        this.format = format;
        this.dauer = dauer;

    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public String toString() {
        return ("Hörbuch: " + " Artikelnummer: " + this.getArtikelNummer() + " \"" + this.getTitel() + "\" von " + this.getAuthor() + " vom " + this.getVerlag() + " Verlag " + " erschienen im Jahre: " + this.getErscheinungsjahr() + " in der Sprache " + this.getSprache() + "des Genres: " + this.getGenre() + " kostet " + this.getPreis() + " Euro" + " " + this.getFormat() + " Format: " + " Dauer: " + this.getDauer());
    }



}

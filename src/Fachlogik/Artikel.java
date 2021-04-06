package Fachlogik;

import Datenhaltung.ArtikelDAO;
import Datenhaltung.IDAO;

import java.io.OutputStream;


public abstract class Artikel implements IDTO{

    private static int artikelCounter;



    private String artikelNummer;
    private String titel;
    private String author;
    private String verlag;
    private int erscheinungsjahr;
    private String sprache;
    private String genre;
    private double preis;
    private boolean isKatalog;

   
    private Katalog katalog;

    public Artikel() {

    }


    
    public Artikel(String artikelNummer, String titel, String author, String verlag, int erscheinungsjahr, String sprache, String genre, double preis, boolean addKatalog) {
        this.artikelNummer = artikelNummer;
        this.titel = titel;
        this.author = author;
        this.verlag = verlag;
        this.erscheinungsjahr = erscheinungsjahr;
        this.sprache = sprache;
        this.genre = genre;
        this.preis = preis;
        this.isKatalog = addKatalog;

        artikelCounter++;
        
        
        System.out.println(addKatalog);
        
        if(addKatalog){
            if(katalog == null){
                katalog = new Katalog();
            }
            
            katalog.addArtikel(this);
        }

    }

    public String getArtikelNummer() {
        return artikelNummer;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setArtikelNummer(String artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public double getPreis() {
        return preis;
    }

    public static int getArtikelCounter() {
        return artikelCounter;
    }

    public static void setArtikelCounter(int artikelCounter) {
        Artikel.artikelCounter = artikelCounter;
    }

  
    
     public boolean getIsKatalog() {
        return isKatalog;
    }


}

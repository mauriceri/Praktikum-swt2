package Fachlogik;



import java.io.Serializable;

public class Kunde implements Serializable {

    private final int id;
    private static int idcounter = 0;

    private String name;
    private String vorname;
    private Adresse adresse;
    private String eMail;


    /**
     * 
     * @param name Name
     * @param vorname Vorname
     * @param adresse Komplexer Datentyp
     * @param eMail eMail
     */
    public Kunde(String name, String vorname, Adresse adresse, String eMail) {

        this.name = name;
        this.vorname = vorname;
        this.eMail = eMail;
        this.adresse = adresse;
        this.id = idcounter;
        idcounter++;

    }

    //Getter / setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return eMail;
    }

    public static void setIdcount(int s) {
        idcounter = s;
    }

    
    public String getStrasse(){
        return adresse.getStrasse();
    }
   
    
    public int getHausnummer(){
        return adresse.getHausnummer();
    }
    
    public String getPlz(){
        return adresse.getPlz();
    }
    
    public String getOrt(){
        return adresse.getOrt();
    }
    
    public String getLand(){
        return adresse.getLand();
    }
    

    @Override
    public String toString(){

        return ("Kunde: " + "Kundennummer: " + getId() + " Name: " + this.getName() + ", " + this.getVorname() + " Email: " + getEmail());
    }

}

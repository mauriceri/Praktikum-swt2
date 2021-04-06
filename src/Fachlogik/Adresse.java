package Fachlogik;

import java.io.Serializable;

public class Adresse implements Serializable {

    private String strasse;
    private int hausnummer;
    private String plz;
    private String ort;
    private String land;

    public Adresse(String strasse, int hausnummer, String plz, String ort, String land) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public String getLand() {
        return land;
    }
}

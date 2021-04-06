package Datenhaltung;

import Fachlogik.Adresse;
import Fachlogik.Kunde;
import Log.MyLogger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class KundeDAO implements IDAO<Kunde> {

    private Logger log = MyLogger.getInstance().getLogger();
    
    //Aufgabe 2 mit DB
    DBConnection connect = new DBConnection();
    Connection conn;
    //KundeDB

    
    /**
     * Speichert ein Kunde in der DB 
     * @param object Objekt vom Typ Kunde 
     */
    
    @Override
    public void speicher(Kunde object) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = connect.connect();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO `kunde`( `Nachname`, `Vorname`, `eMail`, `Strasse`, `Hausnummer`, `PLZ`, `Ort`, `Land`) VALUES (?,?,?,?,?,?,?,?) ");
            ps.setString(1, object.getName());
            ps.setString(2, object.getVorname());
            ps.setString(3, object.getEmail());
            ps.setString(4, object.getAdresse().getStrasse());
            ps.setInt(5, object.getAdresse().getHausnummer());
            ps.setString(6, object.getAdresse().getPlz());
            ps.setString(7, object.getAdresse().getOrt());
            ps.setString(8, object.getAdresse().getLand());

            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            log.severe("Class not found");
        } catch (InstantiationException ex) {
            log.severe("Instance failed");
        } catch (IllegalAccessException ex) {
            log.severe("Illegal Access");
        } catch (SQLException ex) {
            log.severe("SQL statement failed");
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException ex) {
               log.severe("SQL statement failed");
            }
        }

    }

   
   
    /**
     * Speichert ganze liste in DB
     * @param liste List der Kunden
     */
    
    @Override
    public void speicherListe(List<Kunde> liste) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = connect.connect();

            for (Kunde k : liste) {

                PreparedStatement ps = conn.prepareStatement("INSERT INTO `kunde`( `Nachname`, `Vorname`, `eMail`, `Strasse`, `Hausnummer`, `PLZ`, `Ort`, `Land`) VALUES (?,?,?,?,?,?,?,?) ");
                ps.setString(1, k.getName());
                ps.setString(2, k.getVorname());
                ps.setString(3, k.getEmail());
                ps.setString(4, k.getAdresse().getStrasse());
                ps.setInt(5, k.getAdresse().getHausnummer());
                ps.setString(6, k.getAdresse().getPlz());
                ps.setString(7, k.getAdresse().getOrt());
                ps.setString(8, k.getAdresse().getLand());

                ps.executeUpdate();
              

            }
        } catch (Exception e) {
           log.severe("Verbindung fehlgeschlagen");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.severe("Verbindung fehlgeschlagen");
            }
        }

    }

    /**
     * Lädt ganze liste aus DB
     * @return Liste von Kunden aus DB
     */
   
    @Override
    public List<Kunde> laden() {

        List<Kunde> liste = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = connect.connect();

            ResultSet rs = conn.createStatement().executeQuery("select * from  kunde");
            while (rs.next()) {

                String name = rs.getString("Nachname");
                String vname = rs.getString("Vorname");
                String eMail = rs.getString("eMail");
                String str = rs.getString("Strasse");
                int hnr = rs.getInt("Hausnummer");
                String plz = rs.getString("PLZ");
                String ort = rs.getString("Ort");
                String land = rs.getString("Land");

                Kunde k = new Kunde(name, vname, new Adresse(str, hnr, plz, ort, land), eMail);

                liste.add(k);
            }

        } catch (Exception e) {
           log.severe("Verbindung fehlgeschlagen");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.severe("Verbindung fehlgeschlagen");
            }
        }

        return liste;
    }
}

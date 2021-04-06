package Datenhaltung;

import Fachlogik.Artikel;
import Fachlogik.Buch;
import Fachlogik.Hoerbuch;
import Fachlogik.Kunde;
import Log.MyLogger;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArtikelDAO implements IDAO<Artikel> {

    private Logger log = MyLogger.getInstance().getLogger();
    
    DBConnection connect = new DBConnection();
    Connection conn;

    /**
     * Fügt ein Artikel zur Datenbank hinzu
     * @param object Objekt vom typ Artikel
     */
    
    @Override
    public void speicher(Artikel object) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = connect.connect();
            
           
            if (object instanceof Buch) {
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO `buch`( `ArtikelNummer`, `Titel`, `Author`, `Verlag`, `Erscheinungsjahr`, `Sprache`, `Genre`, `Seitenanzahl`, `CoverArt`, `Preis` ) VALUES (?,?,?,?,?,?,?,?,?,?) ");
                    ps.setString(1, object.getArtikelNummer());
                    ps.setString(2, object.getTitel());
                    ps.setString(3, object.getAuthor());
                    ps.setString(4, object.getVerlag());
                    ps.setInt(5, object.getErscheinungsjahr());
                    ps.setString(6, object.getSprache());
                    ps.setString(7, object.getGenre());
                    ps.setInt(8, ((Buch) object).getSeitenanzahl());
                    ps.setString(9, ((Buch) object).getArt());
                    ps.setDouble(10, object.getPreis());
                    ps.executeUpdate();
                   

                } else if (object instanceof Hoerbuch) {
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO `hoerbuch`(`ArtikelNummer`, `Titel`, `Author`, `Verlag`, `Erscheinungsjahr`, `Sprache`, `Genre`, `Dauer`, `Format`, `Preis`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, object.getArtikelNummer());
                    ps.setString(2, object.getTitel());
                    ps.setString(3, object.getAuthor());
                    ps.setString(4, object.getVerlag());
                    ps.setInt(5, object.getErscheinungsjahr());
                    ps.setString(6, object.getSprache());
                    ps.setString(7, object.getGenre());
                    ps.setInt(8, ((Hoerbuch) object).getDauer());
                    ps.setString(9, ((Hoerbuch) object).getFormat());
                    ps.setDouble(10, object.getPreis());
                    ps.executeUpdate();
                    
                }
            
        } catch (SQLException ex) {
            log.severe("Sql Exception");
        } catch (ClassNotFoundException ex) {
            log.severe("ClassNotFound Exception");
        }catch (Exception ex){
            log.severe("Generic Exception");
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                log.severe("Sql Exception");
            }
        }
        
    }
    
    /**
     * Speichert ganze liste in Datenbank
     * @param liste List von Artikeln
     */
   
    @Override
    public void speicherListe(List<Artikel> liste) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
   
            conn = connect.connect();
            for (Artikel b : liste) {
                if (b instanceof Buch) {
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO `buch`( `ArtikelNummer`, `Titel`, `Author`, `Verlag`, `Erscheinungsjahr`, `Sprache`, `Genre`, `Seitenanzahl`, `CoverArt`, `Preis` ) VALUES (?,?,?,?,?,?,?,?,?,?) ");
                    ps.setString(1, b.getArtikelNummer());
                    ps.setString(2, b.getTitel());
                    ps.setString(3, b.getAuthor());
                    ps.setString(4, b.getVerlag());
                    ps.setInt(5, b.getErscheinungsjahr());
                    ps.setString(6, b.getSprache());
                    ps.setString(7, b.getGenre());
                    ps.setInt(8, ((Buch) b).getSeitenanzahl());
                    ps.setString(9, ((Buch) b).getArt());
                    ps.setDouble(10, b.getPreis());
                    ps.executeUpdate();
                    //conn.commit();

                } else if (b instanceof Hoerbuch) {
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO `hoerbuch`(`ArtikelNummer`, `Titel`, `Author`, `Verlag`, `Erscheinungsjahr`, `Sprache`, `Genre`, `Dauer`, `Format`, `Preis`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, b.getArtikelNummer());
                    ps.setString(2, b.getTitel());
                    ps.setString(3, b.getAuthor());
                    ps.setString(4, b.getVerlag());
                    ps.setInt(5, b.getErscheinungsjahr());
                    ps.setString(6, b.getSprache());
                    ps.setString(7, b.getGenre());
                    ps.setInt(8, ((Hoerbuch) b).getDauer());
                    ps.setString(9, ((Hoerbuch) b).getFormat());
                    ps.setDouble(10, b.getPreis());
                    ps.executeUpdate();
               
                }
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
     * Lädt ganze liste aus Datenbank
     * @return Liste von Artikel aus Datenbank
     */
    
    @Override
    public List<Artikel> laden() {

        List<Artikel> liste = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/Medienverwaltung?characterEncoding=latin1&serverTimezone=CET", "root", "");
            conn = connect.connect();
            ResultSet rs = conn.createStatement().executeQuery("select * from  buch");
            while (rs.next()) {

                String anr = rs.getString("ArtikelNummer");
                String titel = rs.getString("Titel");
                String author = rs.getString("Author");
                String verlag = rs.getString("Verlag");
                int eJahr = rs.getInt("Erscheinungsjahr");
                String spr = rs.getString("Sprache");
                String gen = rs.getString("Genre");
                int sAnz = rs.getInt("Seitenanzahl");
                String cArt = rs.getString("CoverArt");
                double preis = rs.getDouble("Preis");

                Buch a = new Buch();
                a.setArtikelNummer(anr);
                a.setTitel(titel);
                a.setAuthor(author);
                a.setVerlag(verlag);
                a.setErscheinungsjahr(eJahr);
                a.setSprache(spr);
                a.setGenre(gen);
                a.setSeitenanzahl(sAnz);
                a.setArt(cArt);
                a.setPreis(preis);

                liste.add(a);
            }

            ResultSet rs2 = conn.createStatement().executeQuery("select * from  hoerbuch");
            while (rs2.next()) {

                String anr = rs2.getString("ArtikelNummer");
                String titel = rs2.getString("Titel");
                String author = rs2.getString("Author");
                String verlag = rs2.getString("Verlag");
                int eJahr = rs2.getInt("Erscheinungsjahr");
                String spr = rs2.getString("Sprache");
                String gen = rs2.getString("Genre");
                int dauer = rs2.getInt("Dauer");
                String format = rs2.getString("Format");
                double preis = rs2.getDouble("Preis");

                
                Hoerbuch b = new Hoerbuch();
                b.setArtikelNummer(anr);
                b.setTitel(titel);
                b.setAuthor(author);
                b.setVerlag(verlag);
                b.setErscheinungsjahr(eJahr);
                b.setSprache(spr);
                b.setGenre(gen);
                b.setDauer(dauer);
                b.setFormat(format);
                b.setPreis(preis);

                liste.add(b);

            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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

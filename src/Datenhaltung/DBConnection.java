/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenhaltung;

/**
 *
 * @author naber002
 */
import java.util.ArrayList;
import java.util.List;

import Fachlogik.*;
import Log.MyLogger;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {

    private Connection conn;
    private Logger log = MyLogger.getInstance().getLogger();
    
    
    //erzeugt eine Verbindung zur Datenkbank
    public Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/buchshopdb?characterEncoding=latin1&serverTimezone=CET", "root", "");
            if (!conn.isClosed()) {
                log.info("Verbindung zur Datenkbank hergestellt");
            }
        } catch (Exception e) {
            log.severe("Verbinung fehlgeschlagen");
        }
        
        return conn;
    }

}

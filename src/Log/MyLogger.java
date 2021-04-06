/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author maric010
 */
public class MyLogger {

    private static MyLogger instance;

    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }

        return instance;
    }

    private MyLogger() {

    }

    public Logger getLogger() {
        Logger logger = Logger.getAnonymousLogger();
        LogManager manager = LogManager.getLogManager();

        try {
            manager.readConfiguration(new FileInputStream("src/Log/logging.properties"));
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }

        return logger;
    }
}

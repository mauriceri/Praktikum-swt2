/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Log.MyLogger;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author maric010
 */
public class Main extends Application {


    public static void main(String[] args) {

        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {        

        SelectView sv = new SelectView(primaryStage);

        sv.showView();

    }

   
}

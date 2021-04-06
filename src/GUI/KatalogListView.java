/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author maric010
 */
public class KatalogListView extends ModalStage {
    
   
    private Controller controller;

    ResourceBundle r;
    
    public KatalogListView(Stage stage, Controller controller, ResourceBundle r){
        super(stage);
        this.controller = controller;
        this.r = r;
    }

    public void showView() {

        TableView table = new TableView();
        table.setEditable(false);

        TableColumn artikelnummerCol = new TableColumn(r.getString("artikelnummer"));
        TableColumn titelCol = new TableColumn(r.getString("titel"));
        TableColumn preisCol = new TableColumn(r.getString("preis"));

        artikelnummerCol.setCellValueFactory(new PropertyValueFactory<>("artikelNummer"));
        titelCol.setCellValueFactory(new PropertyValueFactory<>("titel"));
        preisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));
        
        table.setItems(controller.getKatalogList());

        table.getColumns().addAll(artikelnummerCol, titelCol, preisCol);
        
        
        Scene scene = new Scene(table, 242,300);
        setTitle(r.getString("katalog"));
        setScene(scene);
        show();
        
    }

}

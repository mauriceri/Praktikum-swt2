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
public class BuchListView extends ModalStage {
    
    private Controller controller;




    ResourceBundle r;


    public BuchListView(Stage stage, Controller controller, ResourceBundle r){
        super(stage);
        this.controller= controller;
        this.r = r;
        
    }
    
    void showView(){
        
         TableView table = new TableView();
        table.setEditable(false);

        TableColumn artikelnummerCol = new TableColumn(r.getString("artikelnummer"));
        TableColumn titelCol = new TableColumn(r.getString("titel"));
        TableColumn autorCol = new TableColumn(r.getString("autor"));
        TableColumn verlagCol = new TableColumn(r.getString("verlag"));
        TableColumn spracheCol = new TableColumn(r.getString("sprache"));
        TableColumn genreCol = new TableColumn(r.getString("genre"));
        TableColumn erscheinungsjahrCol = new TableColumn(r.getString("erscheinungsjahr"));
        TableColumn preisCol = new TableColumn(r.getString("preis"));
        TableColumn artCol = new TableColumn(r.getString("art"));
        TableColumn seitenanzahlCol = new TableColumn(r.getString("seitenanzahl"));
        
        artikelnummerCol.setCellValueFactory(new PropertyValueFactory<>("artikelNummer"));
        titelCol.setCellValueFactory(new PropertyValueFactory<>("titel"));
        autorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        verlagCol.setCellValueFactory(new PropertyValueFactory<>("verlag"));
        spracheCol.setCellValueFactory(new PropertyValueFactory<>("sprache"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        erscheinungsjahrCol.setCellValueFactory(new PropertyValueFactory<>("erscheinungsjahr"));
        preisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));
        artCol.setCellValueFactory(new PropertyValueFactory<>("art"));
        seitenanzahlCol.setCellValueFactory(new PropertyValueFactory<>("seitenanzahl"));
        
        
        
        
        table.setItems(controller.getBuchList());
        

        table.getColumns().addAll(artikelnummerCol, titelCol, autorCol,verlagCol ,spracheCol ,genreCol ,erscheinungsjahrCol ,preisCol ,artCol, seitenanzahlCol);
        
        Scene scene = new Scene(table);
        setTitle(r.getString("buchliste"));
        setScene(scene);
        show();
    }
    
    
}

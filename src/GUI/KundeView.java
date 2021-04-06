/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.Artikel;
import Fachlogik.Kunde;

import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author maric010
 */
public class KundeView {

    private Stage stage;

    private Controller controller;

    ObservableList<Kunde> ol = FXCollections.observableArrayList();
    ResourceBundle r;

    public KundeView(Stage stage, ResourceBundle r) {
        controller = new Controller();
        this.stage = stage;
        controller.kundeViewLoad();
        this.r = r;

    }

    void showView() {

        ObservableList<Artikel> ol = FXCollections.observableArrayList();

        ListView listView = new ListView(ol);
        controller.setWarenkorbObl(ol);


        VBox vBox = new VBox();
        MenuBar menuBar = new MenuBar();

        Menu m_suche = new Menu(r.getString("artikelsuche"));
        Menu m_warenkorb = new Menu(r.getString("warenkorb"));
        Menu m_kasse = new Menu(r.getString("kasse"));

        Menu m_zahlmenu = new Menu(r.getString("zahlungsart"));

        MenuItem paypal = new MenuItem(r.getString("paypal"));
        MenuItem visa = new MenuItem(r.getString("visa"));
        MenuItem lastschrift = new MenuItem(r.getString("lastschrift"));
        MenuItem nachname = new MenuItem(r.getString("nachname"));

        m_zahlmenu.getItems().addAll(paypal, visa, lastschrift, nachname);


        MenuItem artikelnummersuche = new MenuItem(r.getString("artikelsuchen"));


        MenuItem gesamtpreisanzeigen = new MenuItem(r.getString("gesamtpreisanzeigen"));
        MenuItem artikelloeschen = new MenuItem(r.getString("artikelloeschen"));


        MenuItem kaufen = new MenuItem(r.getString("kaufen"));
        MenuItem abbrechen = new MenuItem(r.getString("abbrechen"));


        m_suche.getItems().addAll(artikelnummersuche);
        m_warenkorb.getItems().addAll(gesamtpreisanzeigen, artikelloeschen);
        m_kasse.getItems().addAll(m_zahlmenu, kaufen, abbrechen);

        menuBar.getMenus().addAll(m_suche, m_warenkorb, m_kasse);
        vBox.getChildren().addAll(menuBar, listView);


        artikelnummersuche.setOnAction(e -> new ArtikelSuchView(stage, controller, r).showView());


        gesamtpreisanzeigen.setOnAction(e -> {

            Double preis = controller.gesamtPreisAnzeigen();
            MessageView.create(stage, r.getString("gesamtpreisanzeigen"), String.valueOf(preis)).showView();
        });

        artikelloeschen.setOnAction(e -> new WarenkorbLoeschView(stage, controller, r).showView());

        abbrechen.setOnAction(e -> {
            MessageView.create(stage, r.getString("abbrechen"), "Ihr kauf wurde abgebrochen").showView();
            Platform.exit();
        });

        kaufen.setOnAction(e -> {
            MessageView.create(stage, r.getString("kaufen"), r.getString("danke")).showView();

            Platform.exit();
        });

        paypal.setOnAction(e -> MessageView.create(stage, r.getString("zahlungsart"), r.getString("paypal_auswahl")).showView());
        visa.setOnAction(e -> MessageView.create(stage, r.getString("zahlungsart"), r.getString("visa_auswahl")).showView());
        lastschrift.setOnAction(e -> MessageView.create(stage, r.getString("zahlungsart"), r.getString("lastschrift_auswahl")).showView());
        nachname.setOnAction(e -> MessageView.create(stage, r.getString("zahlungsart"), r.getString("nachname_auswahl")).showView());

        Scene scene = new Scene(vBox, 600, 400);

        stage.setTitle(r.getString("titel_kundeview"));
        stage.setScene(scene);
        stage.show();

    }
}

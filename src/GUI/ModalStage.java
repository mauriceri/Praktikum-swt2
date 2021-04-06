/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author maric010
 */
public abstract class ModalStage extends Stage{
    
    public ModalStage(Stage stage){
        super();
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }
    
}

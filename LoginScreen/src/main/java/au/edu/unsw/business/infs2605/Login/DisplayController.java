/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author YXTing
 */
public class DisplayController {
    
    @FXML
    private void handleNavigationFavourites(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    public void initialize() {
        
    }
}

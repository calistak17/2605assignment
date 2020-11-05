package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {
    
    Database database = new Database();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label outputLabel;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("clicked");
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        boolean success = database.login(username, password);

        if (success) {
            App.setRoot("secondary");
        } else {
            outputLabel.setText("Incorrect username or password");
            outputLabel.setVisible(true);
        }
    }

    @FXML
    public void initialize() {
        outputLabel.setVisible(false);
    }

}

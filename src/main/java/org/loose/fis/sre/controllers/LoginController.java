package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.loose.fis.sre.exceptions.FoundUserException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Button logInButton;

    @FXML
    private Label logInLabel;

    public void initialize() {
        choiceBox.getItems().addAll("Client", "Admin");
    }

    public void logInOnAction(ActionEvent event) throws IOException{
        if(userField.getText().isBlank() || passwordField.getText().isBlank() || choiceBox.getValue() == null) {
            logInLabel.setText("Campuri Invalide!");
        } else {
            try {
                UserService.findUser(userField.getText(), passwordField.getText(), (String) choiceBox.getValue());
                logInLabel.setText("Username-ul si parola nu corespund unui cont existent!");
            } catch (FoundUserException e) {
                if (((String) (choiceBox.getValue())).equals("Admin")) {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPanel.fxml"));
                    Stage myStage = (Stage) logInButton.getScene().getWindow();
                    Scene scene = new Scene(root, 1080, 720);
                    myStage.setScene(scene);
                    myStage.show();
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("userPanel.fxml"));
                    Parent root = loader.load();
                    UserPanelController userPanelController = loader.getController();
                    userPanelController.setUsername(userField.getText());
                    Stage myStage = (Stage) logInButton.getScene().getWindow();
                    Scene scene = new Scene(root, 1080, 720);
                    myStage.setScene(scene);
                    myStage.show();
                }
            }
        }
    }

    public void signUpOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage myStage = (Stage) logInButton.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.close();
    }
}

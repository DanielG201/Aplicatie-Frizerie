package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.awt.*;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField userField, nameField, addressField, emailField, phoneField;

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Label registerLabel;

    @FXML
    private PasswordField passwordField;

    public void initialize() {
        choiceBox.getItems().addAll("Client", "Admin");
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) registerLabel.getScene().getWindow();
        stage.close();
    }

    public void registerOnAction(ActionEvent event) throws IOException{
        if (userField.getText().isBlank() || passwordField.getText().isBlank() || addressField.getText().isBlank() || emailField.getText().isBlank() || nameField.getText().isBlank() || phoneField.getText().isBlank() || choiceBox.getValue() == null) {
            registerLabel.setText("Va rog sa introduceti toate datele!");
        } else {
            try {
                registerLabel.setText("");
                UserService.addUser(userField.getText(), passwordField.getText(), (String) choiceBox.getValue(), nameField.getText(), addressField.getText(), emailField.getText(), phoneField.getText());
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
                Stage myStage = (Stage) registerLabel.getScene().getWindow();
                Scene scene = new Scene(root, 1080, 720);
                myStage.setScene(scene);
                myStage.show();
            } catch (UsernameAlreadyExistsException e) {
                registerLabel.setText("Username-ul exista deja!");
            }
        }
    }

    public void signInOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage myStage = (Stage) registerLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }
}

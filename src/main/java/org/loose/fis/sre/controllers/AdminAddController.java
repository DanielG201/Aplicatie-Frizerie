package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.ReservationAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.ReservationService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class AdminAddController {

    @FXML
    private Label titleLabel, registerLabel;

    @FXML
    private TextField nameField,phoneField,timeField,shopField,barberField;

    public void addOnAction(ActionEvent event){
        if (nameField.getText().isBlank() || phoneField.getText().isBlank() || timeField.getText().isBlank() || shopField.getText().isBlank() || barberField.getText().isBlank()) {
            registerLabel.setText("Va rog sa introduceti toate datele!");
        } else {
            try {
                registerLabel.setText("");
                ReservationService.addReservation(nameField.getText(), phoneField.getText(),timeField.getText(),shopField.getText(), barberField.getText());
                registerLabel.setText("Rezervare Efectuata!");
            } catch (ReservationAlreadyExistsException e) {
                registerLabel.setText("Exista deja o rezervare la ora specificata!");
            }
        }
    }

    public void logOutOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }

    public void backOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPanel.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }
}

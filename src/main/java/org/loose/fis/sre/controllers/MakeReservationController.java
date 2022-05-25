package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.models.Reservation;
import org.loose.fis.sre.services.ReservationService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class MakeReservationController {
    @FXML
    private Label titleLabel, reservationLabel;

    @FXML
    private TextField timeField,phoneField,nameField;

    public void reservOnAction(ActionEvent event){
        if (nameField.getText().isBlank() || phoneField.getText().isBlank() || timeField.getText().isBlank()) {
            reservationLabel.setText("Va rog sa introduceti toate datele!");
        } else {
            try {
                reservationLabel.setText("");
                ReservationService.editReservation(nameField.getText(), phoneField.getText(), timeField.getText());
                reservationLabel.setText("Rezervarea a fost efectuata cu succes!");
            } catch (ReservationNotFound e) {
                reservationLabel.setText("Ora aleasa nu corespunde cu o Rezervare");
            } catch (ReservationNotFree e) {
                reservationLabel.setText("Acea ora este rezervata deja!");
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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("userPanel.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }
}

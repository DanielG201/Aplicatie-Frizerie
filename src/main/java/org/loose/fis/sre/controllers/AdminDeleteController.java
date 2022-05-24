package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.ReservationNotFound;
import org.loose.fis.sre.models.Reservation;
import org.loose.fis.sre.services.ReservationService;

import java.io.IOException;


public class AdminDeleteController {

    @FXML
    private Label titleLabel, deleteLabel;

    @FXML
    private TextField timeField;

    public void logOutOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }

    public void backOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPanel.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void deleteOnAction(ActionEvent event) {
        try {
            Reservation toDelete = ReservationService.findReservation(timeField.getText());
            ReservationService.deleteReservation(toDelete);
        } catch (ReservationNotFound e) {
            deleteLabel.setText("O rezervatie la acea ora nu exista...");
        }
    }
}

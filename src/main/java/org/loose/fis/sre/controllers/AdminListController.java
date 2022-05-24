package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.loose.fis.sre.models.Reservation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.loose.fis.sre.services.ReservationService.getReservationRepository;

public class AdminListController {

    @FXML
    private Label titleLabel, registerLabel;

    @FXML
    private TableView<Reservation> table;

    public void initialize(URL location, ResourceBundle resources) {
        table.setItems(getReservationRepository());
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

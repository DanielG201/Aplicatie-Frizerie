package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.models.Reservation;
import org.loose.fis.sre.services.ReservationService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.loose.fis.sre.services.ReservationService.getReservationRepository;

public class AdminListController {

    @FXML
    private Label titleLabel, registerLabel;

    @FXML
    public TableView reservationTable;
    @FXML
    public TableColumn<Reservation, String> nameColumn;
    @FXML
    public TableColumn<Reservation, String> phoneColumn;
    @FXML
    public TableColumn<Reservation, String> timeColumn;

    @FXML
    public TableColumn<Reservation, String> statusColumn;

    @FXML
    public TableColumn<Reservation, String> shopColumn;
    @FXML
    public TableColumn<Reservation, String> barberColumn;

    public ObservableList<Reservation> observableList = FXCollections.observableArrayList();

    public void seeAllReservations(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("clientPhone"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        shopColumn.setCellValueFactory(new PropertyValueFactory<>("barberShopName"));
        barberColumn.setCellValueFactory(new PropertyValueFactory<>("barberName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        for (Reservation reservation : ReservationService.getReservationRepository().find()){
            observableList.add(reservation);
        }
        reservationTable.setItems(observableList);

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

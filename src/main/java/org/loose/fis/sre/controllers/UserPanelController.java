package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UserPanelController {
    @FXML
    private Label titleLabel;

    private static String username;

    public static void setUsername(String username) {
        UserPanelController.username = username;
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }

    public void logOutOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void makeOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("makeReservation.fxml"));
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void listFreeOnAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("listFree.fxml"));
        Parent root = loader.load();
        ListFreeController listFreeController = loader.getController();
        listFreeController.seeFreeReservations();
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }

    public void listMineOnAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("listMine.fxml"));
        Parent root = loader.load();
        ListMineController listMineController = loader.getController();
        listMineController.seeMyReservations(username);
        Stage myStage = (Stage) titleLabel.getScene().getWindow();
        Scene scene = new Scene(root, 1080, 720);
        myStage.setScene(scene);
        myStage.show();
    }
}

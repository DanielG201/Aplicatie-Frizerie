package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminPanelController {
    @FXML
    private Label titleLabel;

    public void logOutOnAction(ActionEvent event){

    }

    public void addOnAction(ActionEvent event){

    }

    public void listOnAction(ActionEvent event){

    }

    public void deleteOnAction(ActionEvent event){

    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }
}

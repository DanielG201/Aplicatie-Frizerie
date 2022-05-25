package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.ReservationService;
import org.loose.fis.sre.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage myStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        ReservationService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        myStage.setTitle("Login");
        Scene scene = new Scene(root, 1080, 720);
        myStage.initStyle(StageStyle.UNDECORATED);
        myStage.setScene(scene);
        myStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

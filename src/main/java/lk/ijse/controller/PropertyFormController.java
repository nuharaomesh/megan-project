package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyFormController {

    @FXML
    void btnPropertyAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyadd_form.fxml")));

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Add a Property");
        stage.centerOnScreen();

        stage.show();
    }
}

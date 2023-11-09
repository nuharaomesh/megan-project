package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyOwnerForm {

    @FXML
    void btnAddPropertyOwnerOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/addpropertyowner_form.fxml")));

        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setTitle("Add a Property Owner");

        stage.setScene(scene);

        stage.show();
    }
}

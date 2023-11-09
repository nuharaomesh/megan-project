package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TenantFormController {

    @FXML
    void btnAddTenantOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/tenantadd_form.fxml")));

        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setTitle("Add Tenant");

        stage.setScene(scene);
        stage.show();
    }

}

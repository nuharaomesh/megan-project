package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyAddFormController {

    @FXML
    private JFXComboBox<?> cmbPropertyOwner;

    @FXML
    private TextField txtPropertyId;

    @FXML
    private TextField txtPropertyId1;

    @FXML
    private TextField txtPropertyId11;

    @FXML
    private TextField txtPropertyId111;

    @FXML
    private TextField txtPropertyId1111;

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }
    @FXML
    void cmbPropertyOwnerOnAction(ActionEvent event) {

    }
    @FXML
    void btnPropertyOwnerAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/addpropertyowner_form.fxml")));

        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setTitle("Add Property Owner");

        stage.setScene(scene);
        stage.show();
    }
}

package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyAddFormController {

    @FXML
    private JFXComboBox<?> cmbPropertyOwner;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPropertyId;

    @FXML
    private TextField txtPropertyName;

    @FXML
    private TextField txtPropertyType;

    @FXML
    private TextField txtRentAmount;

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }
    @FXML
    void cmbPropertyOwnerOnAction(ActionEvent event) {

    }
    @FXML
    void btnPropertyOwnerAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyowneradd_form.fxml")));

        Stage stage = (Stage) this.pane.getScene().getWindow();

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Add a Property Owner");

        stage.show();
    }
}

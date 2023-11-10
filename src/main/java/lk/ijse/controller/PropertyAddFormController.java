package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
import lk.ijse.model.PropertyModel;

import java.io.IOException;
import java.sql.SQLException;

public class PropertyAddFormController {

    @FXML
    private static JFXComboBox<?> cmbPropertyOwner;

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

    private PropertyModel propertyModel = new PropertyModel();

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        double rent_amout = Double.valueOf(txtRentAmount.getText());

        var dto = new PropertyDto(txtPropertyId.getText(), txtPropertyName.getText(), txtAddress.getText(), txtPropertyType.getText(),rent_amout, cmbPropertyOwner.getPromptText());

        try {

            boolean isSaved = propertyModel.saveProperty(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Property saved!!").showAndWait();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
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

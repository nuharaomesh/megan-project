package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.PropertyOwnerModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyAddFormController {

    @FXML
    private JFXComboBox<String> cmbPropertyOwner;

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

    private PropertyOwnerModel ownerModel = new PropertyOwnerModel();


    public void initialize() {
        loadPrpOwners();
    }

    private void loadPrpOwners() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<PropertyOwnerDto> idList = ownerModel.getAllOwners();

            for (PropertyOwnerDto dto: idList) {
                obList.add(dto.getPrpOwner_id());
            }

            System.out.println(cmbPropertyOwner);
            try {

                cmbPropertyOwner.setItems(obList);
            } catch (RuntimeException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        double rent_amount = Double.valueOf(txtRentAmount.getText());

        var dto = new PropertyDto(txtPropertyId.getText(), txtPropertyName.getText(), txtAddress.getText(), txtPropertyType.getText(),rent_amount, cmbPropertyOwner.getPromptText());

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
        String id = cmbPropertyOwner.getValue();

        try {
            PropertyOwnerDto dto = ownerModel.searchOwner(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnPropertyOwnerAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyowneradd_form.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Add a Property Owner");

        stage.show();
    }
}






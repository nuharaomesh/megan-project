package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.PropertyOwnerModel;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;
import java.util.Optional;

public class PropertyOwnerAddFormController {

    @FXML
    private TextField txtPrpOwnerId;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTel;
    @FXML
    private AnchorPane rootNode;
    @FXML
    private TextField txtPropertyName;
    @FXML
    private TextField txtPropertyRent;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtType;
    private PropertyOwnerModel ownerModel = new PropertyOwnerModel();
    private PropertyModel propertyModel = new PropertyModel();
    private Validation validation = new Validation();

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String propertyId = null;
        try {
            propertyId = propertyModel.getPrpId();
            System.out.println(propertyId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        var prpOwnDto = new PropertyOwnerDto(txtEmail.getText(), txtPrpOwnerId.getText(), txtFirstName.getText(), txtLastName.getText(), txtTel.getText());
        var prpDto = new PropertyDto(propertyId, txtPropertyName.getText(), txtAddress.getText(), txtType.getText(), txtPropertyRent.getText(), txtPrpOwnerId.getText());

        try {
            if (validation.getValidation("Property owner", prpOwnDto)) {
                if (validation.getValidation("Property", prpDto)) {
                    if (ownerModel.savePrpOwnAndPrp(prpOwnDto, prpDto)) {
                        new Alert(Alert.AlertType.INFORMATION, "Successfully Added!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
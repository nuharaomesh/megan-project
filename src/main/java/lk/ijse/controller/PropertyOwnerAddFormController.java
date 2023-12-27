package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.PropertyBO;
import lk.ijse.bo.custom.PropertyOwnerBO;
import lk.ijse.bo.custom.impl.PropertyBOImpl;
import lk.ijse.bo.custom.impl.PropertyOwnerBOImpl;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.PropertyOwnerModel;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;
import java.util.Optional;

public class PropertyOwnerAddFormController {

    public TextField txtRoomC;
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

//    private PropertyOwnerModel ownerModel = new PropertyOwnerModel();
//    private PropertyModel propertyModel = new PropertyModel();
    private PropertyOwnerBO propertyOwnerBO = new PropertyOwnerBOImpl();
    private PropertyBO propertyBO = new PropertyBOImpl();
    private Validation validation = new Validation();

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        try {

            String propertyId = propertyBO.getId();
            var prpOwnDto = new PropertyOwnerDto(txtEmail.getText(), txtPrpOwnerId.getText(), txtFirstName.getText(), txtLastName.getText(), txtTel.getText());
            var prpDto = new PropertyDto(propertyId, txtPropertyName.getText(), txtAddress.getText(), txtType.getText(), txtPropertyRent.getText(), txtRoomC.getText(), txtPrpOwnerId.getText());

            if (validation.getValidation("Property owner", prpOwnDto)) {
                if (validation.getValidation("Property", prpDto)) {
                    if (propertyOwnerBO.savePrpOwnAndPrp(prpOwnDto, prpDto)) {
                        new Alert(Alert.AlertType.INFORMATION, "Successfully Added!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
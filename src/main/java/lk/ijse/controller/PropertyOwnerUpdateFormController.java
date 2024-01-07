package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PropertyOwnerBO;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;

public class PropertyOwnerUpdateFormController {

    public Label lblPrpOwnerId;
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtTel;

    private PropertyOwnerBO propertyOwnerBO = (PropertyOwnerBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.PROPERTY_OWNER);
    private Validation validation = Validation.getInstance();

    public void initialize() {
        loadPrpOwners();
    }

    private void loadPrpOwners() {

        try {
            PropertyOwnerDto dto = propertyOwnerBO.searchOwner(PropertyOwnerFormController.email);

            lblPrpOwnerId.setText(dto.getPrpOwner_id());
            txtFirstName.setText(dto.getFirst_name());
            txtLastName.setText(dto.getLast_name());
            txtEmail.setText(dto.getEmail());
            txtTel.setText(dto.getTel_no());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        PropertyOwnerDto dto = new PropertyOwnerDto(txtEmail.getText(), lblPrpOwnerId.getText(), txtFirstName.getText(), txtLastName.getText(), txtTel.getText());

        try {
            if (validation.getValidation("Property owner", dto)) {
                if (propertyOwnerBO.updatePrpOwner(dto)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Property owner updated!!").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

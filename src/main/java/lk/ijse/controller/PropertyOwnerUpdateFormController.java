package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyOwnerModel;

import java.sql.SQLException;

public class PropertyOwnerUpdateFormController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtTel;

    private PropertyOwnerModel ownerModel = new PropertyOwnerModel();

    public void initialize() {
        loadPrpOwners();
    }

    private void loadPrpOwners() {

        try {
            PropertyOwnerDto dto = ownerModel.getOwner(PropertyOwnerFormController.email);

            txtNIC.setText(dto.getPrpOwner_id());
            txtFirstName.setText(dto.getFirst_name());
            txtLastName.setText(dto.getLast_name());
            txtEmail.setText(dto.getEmail());
            txtTel.setText(dto.getTel_no());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        PropertyOwnerDto dto = new PropertyOwnerDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtTel.getText());

        try {
            if (ownerModel.savePrpOwner(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Property owner updated!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}

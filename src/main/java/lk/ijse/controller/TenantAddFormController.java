package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.TenantDto;
import lk.ijse.model.TenantModel;

import java.sql.SQLException;

public class TenantAddFormController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTel;

    @FXML
    private AnchorPane rootTenant;

    private TenantModel tenantModel = new TenantModel();

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        var dto = new TenantDto(txtId.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtEmail.getText(), txtTel.getText());

        try {

            boolean isSaved = tenantModel.saveTenant(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Tenant saved!!").showAndWait();

                Stage stage = (Stage) this.rootTenant.getScene().getWindow();
                stage.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

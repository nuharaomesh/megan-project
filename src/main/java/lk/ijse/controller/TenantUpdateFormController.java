package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.TenantBO;
import lk.ijse.bo.custom.impl.TenantBOImpl;
import lk.ijse.dto.TenantDto;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;

public class TenantUpdateFormController {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtTel;
    private TenantBO tenantBO = (TenantBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.TENANT);
    private String tenantID = TenantFormController.tenantID;
    private Validation validation = new Validation();

    public void initialize() {

        try {
            TenantDto dto = tenantBO.searchTenant(tenantID);
            txtFirstName.setText(dto.getFirst_name());
            txtLastName.setText(dto.getLast_name());
            txtEmail.setText(dto.getEmail());
            txtTel.setText(dto.getTel_no());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        TenantDto dto  = new TenantDto(tenantID, txtFirstName.getText(),txtLastName.getText(), txtEmail.getText(), txtTel.getText());

        try {
            if (validation.getValidation("Tenant", dto)) {
                if (tenantBO.updateTnt(dto)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Tenant Updated!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

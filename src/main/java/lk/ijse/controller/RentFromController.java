package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TextField;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.*;
import lk.ijse.model.*;

import java.sql.Connection;
import java.sql.SQLException;

public class RentFromController {

    @FXML
    private DatePicker calLeaseEndDate;

    @FXML
    private DatePicker calLeaseStartDate;

    @FXML
    private DatePicker calPaymentData;

    @FXML
    private JFXComboBox<?> cmbPropertyManager;

    @FXML
    private Label lnlPropertyN;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAgreement;

    @FXML
    private TextField txtBailiffFirstName;

    @FXML
    private TextField txtBailiffId;

    @FXML
    private TextField txtBailiffLastName;

    @FXML
    private TextField txtBailiffTel;

    @FXML
    private TextField txtBailiffEmail;

    @FXML
    private TextField txtOfficeAddress;

    @FXML
    private TextField txtPaymentAmount;

    @FXML
    private TextField txtPaymentId;

    @FXML
    private TextField txtRentId;

    @FXML
    private TextField txtTenantFirstName;

    @FXML
    private TextField txtTenantId;

    @FXML
    private TextField txtTenantLastName;

    @FXML
    private TextField txtTenantEmail;

    @FXML
    private TextField txtTenantTel;

    private RentModel rentModel = new RentModel();

    @FXML
    void btnSaveRent(ActionEvent event) {

        var tntDto = new TenantDto(txtTenantId.getText(), txtTenantFirstName.getText(), txtTenantLastName.getText(), txtAddress.getText(), txtTenantEmail.getText(), txtTenantTel.getText());
        var payDto = new PaymentDto(txtPaymentId.getText(), txtPaymentAmount.getText(), calPaymentData.getPromptText());
        var rentDto = new RentDto(txtRentId.getText(), calLeaseStartDate.getPromptText(), Double.valueOf(txtPaymentAmount.getText()), (String) cmbPropertyManager.getValue(), txtPaymentId.getText(), txtTenantId.getText(), PropertyFormController.prpId);
        var agreementDto = new AgreementDto(txtAgreement.getText(), calLeaseStartDate.getPromptText(), calLeaseEndDate.getPromptText(), txtRentId.getText());
        var bailDto = new BailiffDto(txtBailiffId.getText(), txtBailiffFirstName.getText(), txtBailiffLastName.getText(), txtOfficeAddress.getText(), txtBailiffEmail.getText(), txtBailiffTel.getText());
        var agAndBailDto = new AgreementBailiffDto(txtAgreement.getText(), txtBailiffId.getText());

        try {
            if (rentModel.registerRent(tntDto, payDto, rentDto, agreementDto, bailDto, agAndBailDto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Property registered!!").showAndWait();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}

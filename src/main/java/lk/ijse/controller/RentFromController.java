package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TextField;
import lk.ijse.dto.PaymentDto;
import lk.ijse.dto.TenantDto;
import lk.ijse.model.*;

import java.sql.SQLException;

public class RentFromController {

    @FXML
    private DatePicker calender1;

    @FXML
    private DatePicker calender11;

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

    private TenantModel tenantModel = new TenantModel();
    private PaymentModel paymentModel = new PaymentModel();
    private RentModel rentModel = new RentModel();
    private AgreementModel agreementModel = new AgreementModel();
    private BailiffModel bailiffModel = new BailiffModel();
    private AgreementAndBailiffModel aAndBailiffModel = new AgreementAndBailiffModel();

    @FXML
    void btnSaveRent(ActionEvent event) {

        var tntDto = new TenantDto(txtTenantId.getText(), txtTenantFirstName.getText(), txtTenantLastName.getText(), txtAddress.getText(), txtTenantEmail.getText(), txtTenantTel.getText());
        var payDto = new PaymentDto();
        try {
            tenantModel.saveTenant(tntDto);
            paymentModel.savePayment(new PaymentDto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

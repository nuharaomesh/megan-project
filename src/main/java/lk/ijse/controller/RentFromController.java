package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.*;
import lk.ijse.model.*;
import lk.ijse.plugin.Validation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RentFromController {

    @FXML
    private DatePicker calLeaseEndDate;

    @FXML
    private DatePicker calLeaseStartDate;

    @FXML
    private DatePicker calPaymentDate;

    @FXML
    private JFXComboBox<String> cmbPropertyManager;

    @FXML
    private Label lnlPropertyN;

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
    private TextField txtTenantFirstName;

    @FXML
    private TextField txtTenantId;

    @FXML
    private TextField txtTenantLastName;

    @FXML
    private TextField txtTenantEmail;

    @FXML
    private TextField txtTenantTel;

    @FXML
    private AnchorPane root;

    private RentModel rentModel = new RentModel();
    private EmployeeModel employeeModel = new EmployeeModel();
    private Validation validation = new Validation();
    private PaymentModel  paymentModel = new PaymentModel();
    private AgreementModel agreementModel = new AgreementModel();

    public void initialize() {
        loadPm();
    }

    public void loadPm() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> idList = employeeModel.getAllEmpl();

            for (EmployeeDto dto: idList) {
                obList.add(dto.getNIC());
            }
            cmbPropertyManager.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/property_form.fxml")));
    }
    @FXML
    void btnSaveRent(ActionEvent event) {

        String payId = null;
        String AgId = null;
        String rentId = null;
        try {
            rentId = rentModel.genRenID();
            payId = paymentModel.genPayID();
            AgId = agreementModel.genAgID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var tntDto = new TenantDto(txtTenantId.getText(), txtTenantFirstName.getText(), txtTenantLastName.getText(), txtTenantEmail.getText(), txtTenantTel.getText());
        var payDto = new PaymentDto(payId, txtPaymentAmount.getText(), String.valueOf(calPaymentDate.getValue()));
        var rentDto = new RentDto(rentId, String.valueOf(calLeaseStartDate.getValue()), Double.valueOf(txtPaymentAmount.getText()), (String) cmbPropertyManager.getValue(), payId, txtTenantId.getText(), PropertyFormController.prpId);
        var agreementDto = new AgreementDto(AgId, String.valueOf(calLeaseStartDate.getValue()), String.valueOf(calLeaseEndDate.getValue()), rentId);
        var bailDto = new BailiffDto(txtBailiffId.getText(), txtBailiffFirstName.getText(), txtBailiffLastName.getText(), txtOfficeAddress.getText(), txtBailiffEmail.getText(), txtBailiffTel.getText());
        var agAndBailDto = new AgreementBailiffDto(AgId, txtBailiffId.getText());

        try {
            if (validation.getValidation("Tenant", tntDto)) {
                if (validation.getValidation("Payment", payDto)) {
                    if (validation.getValidation("Rent", rentDto)) {
                        if (validation.getValidation("Agreement", agreementDto)) {
                            if (validation.getValidation("Bailiff", bailDto)) {
                                if (rentModel.registerRent(tntDto, payDto, rentDto, agreementDto, bailDto, agAndBailDto)) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Property registered!!").showAndWait();
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}

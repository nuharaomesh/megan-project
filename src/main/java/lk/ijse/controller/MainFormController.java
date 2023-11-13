package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class MainFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnAccount;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnProperty;

    @FXML
    private JFXButton btnPropertyOwner;

    @FXML
    private JFXButton btnReports;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private JFXButton btnTenant;

    @FXML
    private JFXButton btnTenantRequest;

    private JFXButton[] BTN = {btnDashboard, btnPayment, btnTenantRequest, btnProperty, btnTenant, btnPropertyOwner, btnEmployee, btnReports, btnSetting, btnAccount};

    public void initialize() throws IOException{
        loadPage("/view/dashboard_form.fxml");
    }
    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        loadPage("/view/dashboard_form.fxml");
    }

    @FXML
    void btnPropertiesOnAction(ActionEvent event) throws IOException {
        loadPage("/view/property_form.fxml");
    }

    @FXML
    void btnTenantOnAction(ActionEvent event) throws IOException {
        loadPage("/view/tenant_form.fxml");
    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        loadPage("/view/employee_form.fxml");
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException {
        loadPage("/view/payment_form.fxml");
    }

    @FXML
    void btnTenantRequestOnAction(ActionEvent event) throws IOException {
        loadPage("/view/tenantRequest_form.fxml");
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        loadPage("/view/reports_form.fxml");
    }

    @FXML
    void btnPropertyOwnerOnAction(ActionEvent event) throws IOException {
        loadPage("/view/propertyowner_form.fxml");
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) throws IOException {
        loadPage("/view/setting_form.fxml");
    }

    @FXML
    void btnAccountOnAction(ActionEvent event) throws IOException {
        loadPage("/view/account_form.fxml");
    }
    @FXML
    void btnExitOnAction(ActionEvent event) {

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are yor sure?", yes, no).showAndWait();

        if (type.orElse(no) == yes) {
            System.exit(0);
        }
    }

    private void loadPage(String setAddress) throws IOException {
        this.pane.getChildren().clear();
        this.pane.getChildren().add(FXMLLoader.load(this.getClass().getResource(setAddress)));
    }
}

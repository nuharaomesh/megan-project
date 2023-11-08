package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {

    @FXML
    private AnchorPane pane;

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

    private void loadPage(String setAddress) throws IOException {
        this.pane.getChildren().clear();
        this.pane.getChildren().add(FXMLLoader.load(this.getClass().getResource(setAddress)));
    }
}

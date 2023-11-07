package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        this.pane.getChildren().clear();
        this.pane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml")));
    }

    @FXML
    void btnPropertiesOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/property_form.fxml"));
        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }

    @FXML
    void btnTenantOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/tenant_form.fxml"));

        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/employee_form.fxml"));

        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/payment_form.fxml"));

        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }

    @FXML
    void btnTenantRequestOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/tenantRequest_form.fxml"));

        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/reports_form.fxml"));

        this.pane.getChildren().clear();
        this.pane.getChildren().add(rootNode);
    }
}

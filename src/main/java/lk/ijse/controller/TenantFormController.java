package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.TenantBO;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.TenantDto;
import lk.ijse.dto.tm.TenantTm;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;

public class TenantFormController {

    @FXML
    private TableColumn<?, ?> colEmail;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colTel;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblPropertyType;
    @FXML
    private Label lblRent;
    @FXML
    private Label lblTel;
    @FXML
    private Label lblEndDate;
    @FXML
    private Label lblStartDate;
    @FXML
    private TableView<TenantTm> tblTenant;
    public static String tenantID;
    private TenantBO tenantBO = (TenantBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.TENANT);

    Object object;
    public void initialize() {
        setCellValueFactory();
        loadAllTenant();
        tableListener();
    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("tenant_id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
    }

    private void loadAllTenant() {

        tblTenant.getItems().clear();
        /*Get all customers*/
        try {

            HashSet<TenantDto> tntSet = tenantBO.getAllTenant();

            for (TenantDto c : tntSet) {
                tblTenant.getItems().add(new TenantTm(c.getTenant_id(), c.getFirst_name(), c.getEmail(), c.getTel_no()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void tableListener() {

        tblTenant.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValued, newValue) -> {
            try {
                CustomDto dto = tenantBO.getTntDet(newValue.getTenant_id());
                this.tenantID = newValue.getTenant_id();
                setData(dto, newValue, tenantBO.getLeaseDate(newValue.getTenant_id())); //Join query
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setData(CustomDto dto, TenantTm row, CustomDto agDto) {
        lblFirstName.setText(row.getFirst_name());
        lblLastName.setText(dto.getTenantLastName());
        lblEmail.setText(row.getEmail());
        lblTel.setText(row.getTel_no());
        lblRent.setText("Rs. " + dto.getRentAmount());
        lblPropertyType.setText(dto.getPrpType());
        lblStartDate.setText(agDto.getLease_StartDate());
        lblEndDate.setText(agDto.getLease_endDate());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (!lblFirstName.getText().equals("")) {

            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Tenant?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {

                try {
                    if (tenantBO.deleteTenant(lblEmail.getText())) {
                        initialize();
                        clearLbl();
                        new Alert(Alert.AlertType.INFORMATION, "Tenant Deleted!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                    }
                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Select a tenant first!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {

        if (!lblFirstName.getText().equals("")) {

            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/tenantupdate_form.fxml"))));
            stage.centerOnScreen();
            stage.setTitle("Update tenant!!");
            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Select a tenant first!!").show();
        }
    }

    private void clearLbl() {
        lblFirstName.setText("");
        lblLastName.setText("");
        lblEmail.setText("");
        lblPropertyType.setText("");
        lblTel.setText("");
        lblRent.setText("");
    }
}

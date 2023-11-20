package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dto.TenantDto;
import lk.ijse.dto.TenantPrpDto;
import lk.ijse.dto.tm.TenantTm;
import lk.ijse.model.TenantModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
    private Label lblTREMAIL;

    @FXML
    private Label lblTRNAME;

    @FXML
    private Label lblTRRENT;

    @FXML
    private Label lblTRTYPE;

    @FXML
    private Label lblTRTel;

    @FXML
    private TableView<TenantTm> tblTenant;

    private TenantModel tenantModel = new TenantModel();
    public static String tenantID;

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

        ObservableList<TenantTm> obList = FXCollections.observableArrayList();

        try {
            List<TenantDto> dtoList = tenantModel.getAllTenant();

            for (TenantDto dto: dtoList) {
                obList.add(
                        new TenantTm(
                                dto.getTenant_id(),
                                dto.getFirst_name(),
                                dto.getEmail(),
                                dto.getTel_no()
                        )
                );
            }
            tblTenant.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void tableListener() {
        tblTenant.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValued, newValue) -> {
            try {
                lblVisual(true);
                TenantPrpDto dto = tenantModel.searchTnt(newValue.getTenant_id());
                this.tenantID = newValue.getTenant_id();
                setData(dto, newValue);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        });
    }

    private void setData(TenantPrpDto dto, TenantTm row) {
        lblFirstName.setText(row.getFirst_name());
        lblLastName.setText(dto.getLast_name());
        lblEmail.setText(row.getEmail());
        lblTel.setText(row.getTel_no());
        lblRent.setText(String.valueOf(dto.getRent_amount()));
        lblPropertyType.setText(dto.getProperty_type());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/tenantupdate_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Update tenant!!");
        stage.show();
    }

    private void lblVisual(boolean visual) {

        if (visual) {
            lblTRNAME.setStyle("visibility: false");
            lblTREMAIL.setStyle("visibility: false");
            lblTRTel.setStyle("visibility: false");
            lblTRRENT.setStyle("visibility: false");
            lblTRTYPE.setStyle("visibility: false");
        } else {
            lblTRNAME.setStyle("visibility: true");
            lblTREMAIL.setStyle("visibility: true");
            lblTRTel.setStyle("visibility: true");
            lblTRRENT.setStyle("visibility: true");
            lblTRTYPE.setStyle("visibility: true");
        }
    }
}

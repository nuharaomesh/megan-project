package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.PrpOwnerPrppDto;
import lk.ijse.dto.tm.PrpOwnerTm;
import lk.ijse.model.PropertyOwnerModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PropertyOwnerFormController {

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFName;

    @FXML
    private TableColumn<?, ?> colProperty;

    @FXML
    private TableColumn<?, ?> colTele;

    @FXML
    private TableView<PrpOwnerTm> tblPropertyOwner;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblPropertyName;

    @FXML
    private Label lblTel;

    public static String email;

    @FXML
    private JFXButton btnPropertyOwner;

    private PropertyOwnerModel prpOwnerModel = new PropertyOwnerModel();


    public void initialize() {
        setCellValueFactory();
        loadAllPro();
        tableListener();
    }

    private void setCellValueFactory() {
        colFName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTele.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
        colProperty.setCellValueFactory(new PropertyValueFactory<>("property_name"));
    }

    private void loadAllPro() {

        ObservableList<PrpOwnerTm> obList = FXCollections.observableArrayList();

        try {

            List<PrpOwnerPrppDto> dtoList = prpOwnerModel.getAllPrpOwners();

            for (PrpOwnerPrppDto dto : dtoList) {
                obList.add(
                        new PrpOwnerTm(
                                dto.getFirst_name(),
                                dto.getEmail(),
                                dto.getTel(),
                                dto.getProperty_name()
                        )
                );
            }
            tblPropertyOwner.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void tableListener() {
        tblPropertyOwner.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValued, newValue) -> {

            this.email = newValue.getEmail();
            PropertyOwnerDto dto = null;
            try {
                dto = prpOwnerModel.searchLsName(newValue.getEmail());
                setDate(newValue, dto.getLast_name());
            } catch (SQLException e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            }
        });
    }

    private void setDate(PrpOwnerTm row, String lstName) {
        lblFirstName.setText(row.getFirst_name());
        lblLastName.setText(lstName);
        lblPropertyName.setText(row.getProperty_name() + " Owner");
        lblEmail.setText(row.getEmail());
        lblTel.setText(row.getTel_no());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {

        if (!lblFirstName.getText().equals("")) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyownerupdate_form.fxml"))));
            stage.centerOnScreen();
            stage.setTitle("Update property owner!!");
            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "You need select Property owner first!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).show();
        }
    }

    @FXML
    void btnOwnerEditMP(MouseEvent event) {
        btnPropertyOwner.setStyle("-fx-background-color: white");
    }

    @FXML
    void btnOwnerEditMR(MouseEvent event) {
        btnPropertyOwner.setStyle("-fx-background-color: black");
    }
}

package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PropertyOwnerBO;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.tm.CustomTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

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
    private TableView<CustomTM> tblPropertyOwner;
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
    private PropertyOwnerBO prpOwnerBo = (PropertyOwnerBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.PROPERTY_OWNER);

    public void initialize() {
        setCellValueFactory();
        loadAllPro();
        tableListener();
    }

    private void setCellValueFactory() {
        colFName.setCellValueFactory(new PropertyValueFactory<>("poFirstName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("poEmail"));
        colTele.setCellValueFactory(new PropertyValueFactory<>("poTel"));
        colProperty.setCellValueFactory(new PropertyValueFactory<>("prpName"));
    }

    private void loadAllPro() {

        tblPropertyOwner.getItems().clear();
        /*Get all PrpOwners*/
        try {

            HashSet<CustomDto> poSet = prpOwnerBo.getAllPrpOwnAndPrp();

            for (CustomDto c : poSet) {
                tblPropertyOwner.getItems().add(new CustomTM(c.getPoFirstName(), c.getPoEmail(), c.getPoTel(), c.getPrpName()));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void tableListener() {

        tblPropertyOwner.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValued, newValue) -> {


//            this.email = newValue.getEmail();
            PropertyOwnerDto dto = null;
            try {
                dto = prpOwnerBo.searchOwner(newValue.getPoEmail());
                setData(newValue, dto.getLast_name());
            } catch (SQLException e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setData(CustomTM row, String lstName) {
        lblFirstName.setText(row.getPoFirstName());
        lblLastName.setText(lstName);
        lblPropertyName.setText(row.getPrpName() + " Owner");
        lblEmail.setText(row.getPoEmail());
        lblTel.setText(row.getPoTel());
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
}

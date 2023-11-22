package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.tm.PropertyTm;
import lk.ijse.model.PropertyModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PropertyFormController {


    @FXML
    private TableView<PropertyTm> tblProperty;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblPropertyName;

    @FXML
    private Label lblPropertyType;

    @FXML
    private Label lblRentAmount;

    @FXML
    private Label lblTRAddress;

    @FXML
    private Label lblTRPropertyType;

    @FXML
    private Label lblTRRentAmount;

    @FXML
    private AnchorPane pane;

    public static String prpId;

    private PropertyModel prpModel = new PropertyModel();

    public void initialize() {
        setCellValueFactory();
        loadAllPrp();
        tableListener();
        lblVisual(false);
    }

    private void setCellValueFactory() {
            colId.setCellValueFactory(new PropertyValueFactory<>("property_id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("property_name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colAmount.setCellValueFactory(new PropertyValueFactory<>("rent_amount"));
    }

    private void tableListener() {
        tblProperty.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {

            try {
                PropertyDto dto = prpModel.searchPrpType(newValue.getProperty_id());
                setData(newValue, dto.getProperty_type(), dto.getProp_id());
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        });
    }

    private void setData(PropertyTm row, String prpType, String prpId) {
        lblVisual(true);
        lblPropertyName.setText(row.getProperty_name());
        lblRentAmount.setText(String.valueOf(row.getRent_amount()));
        lblAddress.setText(row.getAddress());
        lblPropertyType.setText(prpType);
        this.prpId = prpId;
    }

    private void loadAllPrp() {

        var model = new PropertyModel();

        ObservableList<PropertyTm> obList = FXCollections.observableArrayList();

        try {
            List<PropertyDto> dtoList = model.getAllProperty();

            for (PropertyDto dto : dtoList) {
                obList.add(
                        new PropertyTm(
                                dto.getProp_id(),
                                dto.getName(),
                                dto.getAddress(),
                                "Rs. " + dto.getRent_amount()
                        )
                );
            }
            tblProperty.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        if (!lblPropertyName.getText().equals("")) {
            try {
                if (prpModel.deletePrp(prpId)) {
                    lblVisual(false);
                    loadAllPrp();
                    setlableFalse();
                    new Alert(Alert.AlertType.INFORMATION, "Property Removed!!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Choose a property first!!");
        }
    }

    private void setlableFalse() {
        lblAddress.setText("");
        lblPropertyType.setText("");
        lblRentAmount.setText("");
        lblPropertyName.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyupdate_form.fxml"))));
        stage.centerOnScreen();

        stage.show();
    }
    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {

        if (lblPropertyName.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Choose property first!!").show();
        } else {
            this.pane.getChildren().clear();
            this.pane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/rent_from.fxml")));
        }
    }

    private void lblVisual(boolean visual) {

        if (visual) {
            lblTRAddress.setStyle("visibility: false");
            lblTRPropertyType.setStyle("visibility: false");
            lblTRRentAmount.setStyle("visibility: false");
        } else {
            lblTRAddress.setStyle("visibility: true");
            lblTRPropertyType.setStyle("visibility: true");
            lblTRRentAmount.setStyle("visibility: true");
        }
    }
}

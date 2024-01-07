package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PropertyBO;
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
    private Label lblRoomC;
    @FXML
    private Label lblRentAmount;
    @FXML
    private AnchorPane pane;
    public static String prpId;
    private PropertyBO propertyBO = (PropertyBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.PROPERTY);


    public void initialize() {
        setCellValueFactory();
        loadAllPrp();
        tableListener();
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
                PropertyDto dto = propertyBO.searchPrp(newValue.getProperty_id());
                setData(newValue, dto.getProperty_type(), dto.getProp_id(), dto.getRoomCount());
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setData(PropertyTm row, String prpType, String prpId, String rmCount) {
        lblPropertyName.setText(row.getProperty_name());
        lblRentAmount.setText(String.valueOf(row.getRent_amount()));
        lblAddress.setText(row.getAddress());
        lblPropertyType.setText(prpType);
        lblRoomC.setText(rmCount);
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
                if (propertyBO.deletePrp(prpId)) {
                    loadAllPrp();
                    clearLbl();
                    new Alert(Alert.AlertType.INFORMATION, "Property Removed!!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Choose a property first!!");
        }
    }

    private void clearLbl() {
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
        stage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        loadAllPrp();
                    }
                });
        stage.show();
    }
    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {

        if (!lblPropertyName.getText().equals("")) {
            this.pane.getChildren().clear();
            this.pane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/rent_from.fxml")));
        } else {
            new Alert(Alert.AlertType.ERROR, "Choose property first!!").show();
        }
    }

    @FXML
    void btnAddPropertyOwnerOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyowneradd_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Add a Property Owner");

        stage.show();
    }

    public void btnServiceOnAction(ActionEvent event) throws IOException {

        if (!lblPropertyName.getText().equals("")) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/service_form.fxml"))));
            stage.centerOnScreen();
            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Select a Property first!!").show();
        }
    }
}

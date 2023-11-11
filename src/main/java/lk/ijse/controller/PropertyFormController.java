package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.tm.PropertyTm;
import lk.ijse.model.PropertyModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PropertyFormController {

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAmount;


    @FXML
    private TableView<PropertyTm> tblProperty;

    private PropertyModel prpModel = new PropertyModel();

    public void initialize() {
        setCellValueFactory();
        loadAllPrp();
    }

    private void setCellValueFactory() {
        try {

            colName.setCellValueFactory(new PropertyValueFactory<>("property_name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colAmount.setCellValueFactory(new PropertyValueFactory<>("rent_amount"));
        } catch (IllegalStateException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void loadAllPrp() {

        var model = new PropertyModel();

        ObservableList<PropertyTm> obList = FXCollections.observableArrayList();

        try {
            List<PropertyDto> dtoList = model.getAllProperty();

            for (PropertyDto dto : dtoList) {
                obList.add(
                        new PropertyTm(
                                dto.getName(),
                                dto.getAddress(),
                                dto.getRent_amount()
                        )
                );
                System.out.println(dto.getName());
            }
            tblProperty.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    private void setCellValueFactory() {
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
//    }

//    private void loadAllPrp() {
//        var model = new CustomerModel();
//
//        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();
//
//        try {
//            List<CustomerDto> dtoList = model.getAllCustomer();
//
//            for (CustomerDto dto : dtoList) {
//                obList.add(
//                        new CustomerTm(
//                                dto.getId(),
//                                dto.getName(),
//                                dto.getAddress(),
//                                dto.getTel()
//                        )
//                );
//            }
//
//            tblCustomer.setItems(obList);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @FXML
    void btnPropertyAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyadd_form.fxml")));

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Add a Property");
        stage.centerOnScreen();

        stage.show();
    }
}

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
import javafx.stage.Stage;
import lk.ijse.dto.PropertyDto;
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

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblPropertyName;

    @FXML
    private Label lblPropertyTable;

    @FXML
    private Label lblRentAmount;


    private PropertyModel prpModel = new PropertyModel();

    public void initialize() {
        setCellValueFactory();
        loadAllPrp();
    }

    private void setCellValueFactory() {
            colName.setCellValueFactory(new PropertyValueFactory<>("property_name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colAmount.setCellValueFactory(new PropertyValueFactory<>("rent_amount"));
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

    @FXML
    void btnPropertyAddOnAction(ActionEvent event) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyadd_form.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add a Property");
        stage.centerOnScreen();

        stage.show();
    }

    @FXML
    void btnRentOnAction(ActionEvent event) {

    }
}

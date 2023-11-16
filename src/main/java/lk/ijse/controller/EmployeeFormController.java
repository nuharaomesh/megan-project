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
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.tm.EmployeeTm;
import lk.ijse.model.EmployeeModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeFormController {

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblPosition;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    private EmployeeModel empModel = new EmployeeModel();
    public void initialize() {
        setCellValueFactory();
        loadAllEmp();
        tableListener();
    }

    private void setCellValueFactory() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

    }

    private void loadAllEmp() {

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = empModel.getAllEmpl();

            for (EmployeeDto dto: dtoList) {
                obList.add(
                        new EmployeeTm(
                                dto.getFirst_name(),
                                dto.getAddress(),
                                dto.getEmail(),
                                dto.getPosition()
                        )
                );
            }
            tblEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void tableListener() {

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            try {
                EmployeeDto dto = empModel.searchEmp(newValue.getEmail());
                setData(newValue, dto.getLast_name());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setData(EmployeeTm row, String lastName) {
        lblPosition.setText(row.getPosition());
        lblFirstName.setText(row.getFirst_name());
        lblLastName.setText(lastName);
        lblAddress.setText(row.getAddress());
        lblEmail.setText(row.getEmail());
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/employeeadd_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Add new Employee.");

        stage.show();
    }

    public void btnEditEmpOnAction(ActionEvent event) throws IOException {
        EmployeeEditFormController.EmpEmail = lblEmail.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/employeeedit_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Update Employee detail.");

        stage.show();
    }
}

package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeAddFormController {

    public DatePicker calDOB;
    public TextField txtSalary;
    public JFXComboBox cmbGender;
    public TextField txtTel;
    public DatePicker calPayDate;
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPosition;

    @FXML
    private AnchorPane pane;

    private EmployeeBO employeeBO = new EmployeeBOImpl();
    /*private EmployeeModel empModel = new EmployeeModel();
    private SalaryModel salModel = new SalaryModel();*/
    private Validation validate = new Validation();

    public void initialize() {
        setGender();
    }

    private void setGender() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        obList.add("Male");
        obList.add("Female");

        cmbGender.setItems(obList);
    }

    @FXML
    void btnEmpSaveOnAction(ActionEvent event) {

        String salId = null;

        try {
            salId = employeeBO.genSalId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var empDto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText(), String.valueOf(LocalDate.now()), String.valueOf(cmbGender.getValue()), String.valueOf(calDOB.getValue()), txtTel.getText());
        var salDto = new SalaryDto(salId, txtSalary.getText(), String.valueOf(calPayDate.getValue()), txtNIC.getText());
        if (validate.getValidation("Employee", empDto)) {
            if (validate.getValidation("Salary", salDto)) {
                try {
                    if (employeeBO.saveEmployee(empDto, salDto)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!!! \nDo you want add another?", new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                        clearFields();
                    }
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
            }
        }
    }

    public void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) this.pane.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        txtNIC.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtPosition.setText("");
        txtSalary.setText("");
        calDOB.setPromptText("");
        cmbGender.setValue("");
        txtTel.setText("");
    }
}

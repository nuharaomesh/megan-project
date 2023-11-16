package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.model.EmployeeModel;

import java.sql.SQLException;

public class EmployeeAddFormController {

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

    private EmployeeModel empModel = new EmployeeModel();

    @FXML
    void btnEmpSaveOnAction(ActionEvent event) {
        var dto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText());

        try {
            boolean isSaved = empModel.saveEmp(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}

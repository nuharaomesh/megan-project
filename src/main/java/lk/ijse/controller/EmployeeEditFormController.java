package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.model.EmployeeModel;

import java.sql.SQLException;

public class EmployeeEditFormController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtPosition;

    private EmployeeModel employeeModel = new EmployeeModel();
    public static String EmpEmail;

    public void initialize() {
        try {
            EmployeeDto dto = employeeModel.searchEmp(EmpEmail);

            txtEmail.setText(dto.getEmail());
            txtNIC.setText(dto.getNIC());
            txtFirstName.setText(dto.getFirst_name());
            txtLastName.setText(dto.getLast_name());
            txtAddress.setText(dto.getAddress());
            txtPosition.setText(dto.getPosition());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        var dto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText());

        if (employeeModel.updateEmp(dto)) {

        }
    }
}

package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.model.EmployeeModel;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;
import java.util.Optional;

public class EmployeeEditFormController {

    public DatePicker calDOB;
    public JFXComboBox cmbGen;
    public TextField txtTel;
    public DatePicker calStartDate;
    public TextArea txtAddress;
    public TextField txtSalary;
    public JFXTextArea txtEmpDetails;
    public JFXComboBox cmbJobRole;
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
    @FXML
    private AnchorPane pane;

    private EmployeeModel employeeModel = new EmployeeModel();
    private Validation validation = new Validation();
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

        if (validation.getValidation("Employee", dto)) {
            try {
                if (employeeModel.updateEmp(dto)) {

                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();

                    Stage stage = (Stage) this.pane.getScene().getWindow();
                    stage.close();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) this.pane.getScene().getWindow();
        stage.close();
    }
}

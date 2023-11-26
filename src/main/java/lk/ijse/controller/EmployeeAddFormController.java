package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.model.EmployeeModel;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;
import java.util.Optional;
import java.util.regex.Pattern;

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

    @FXML
    private AnchorPane pane;

    private EmployeeModel empModel = new EmployeeModel();
    private Validation validate = new Validation();

    @FXML
    void btnEmpSaveOnAction(ActionEvent event) {
        var dto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText());

        if (validate.getValidation("Employee", dto)) {
            try {
                if (empModel.saveEmp(dto)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!!! \nDo you want add another?", new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
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
    }
}

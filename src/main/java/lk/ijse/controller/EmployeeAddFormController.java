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

    @FXML
    void btnEmpSaveOnAction(ActionEvent event) {

        if (txtNIC.getText().equals("") && txtFirstName.getText().equals("") && txtLastName.getText().equals("") && txtAddress.getText().equals("") && txtEmail.getText().equals("") && txtPosition.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Missing enter detail make sure you fill the all boxes!!").show();
        } else {
            var dto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText());

            if (isValidated()) {

                try {
                    boolean isSaved = empModel.saveEmp(dto);

                    if (isSaved) {
                        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.CANCEL_CLOSE);
                        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);

                        Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!!! \nDo you want add another?", yes, no).showAndWait();

                        if (type.orElse(yes) == no) {
                            Stage stage = (Stage) this.pane.getScene().getWindow();
                            stage.close();
                        }
                        clearFields();
                    }
                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
            }
        }
    }

    public void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) this.pane.getScene().getWindow();
        stage.close();
    }

    private boolean isValidated() {

        if (!Pattern.matches("[0-9]{10}", txtNIC.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid NIC!!").show();
            return false;
        }

        if (!Pattern.matches("([A-Za-z])+\\w", txtFirstName.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid First name!!").show();
            return false;
        }

        if (!Pattern.matches("([A-Za-z])+\\w", txtLastName.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Last name!!").show();
            return false;
        }

        if (!Pattern.matches("([A-z]+.gmail[.]com)", txtEmail.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email!!").show();
            return false;
        }

        if (!Pattern.matches("([A-Za-z])+\\w", txtAddress.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Address!!").show();
            return false;
        }

        if (!Pattern.matches("[A-z\\s]+\\w", txtPosition.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Position!!").show();
            return false;
        }

        return true;
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

package lk.ijse.controller;

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

    @FXML
    private AnchorPane pane;

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

        try {
            if (employeeModel.updateEmp(dto)) {

                ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!!", ok).showAndWait();

                if (type.orElse(ok) == ok) {
                    Stage stage = (Stage) this.pane.getScene().getWindow();
                    stage.close();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}

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

            try {
                boolean isSaved = empModel.saveEmp(dto);

                if (isSaved) {
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.CANCEL_CLOSE);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);

                    Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!!! \nDo you want add another?", yes, no).showAndWait();

                    if (type.orElse(no) == yes) {
                        Stage stage = (Stage) this.pane.getScene().getWindow();
                        stage.close();
                    }
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }
}

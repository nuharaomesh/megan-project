package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.plugin.Validation;

import java.sql.SQLException;

public class EmployeeEditFormController {

    public DatePicker calDOB;
    public JFXComboBox cmbGen;
    public TextField txtTel;
    public TextArea txtAddress;
    public TextField txtSalary;
    public JFXTextArea txtEmpDetails;
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

    private EmployeeBO employeeBO = new EmployeeBOImpl();
//    private EmployeeModel employeeModel = new EmployeeModel();
    private Validation validation = new Validation();
    public static String EmpEmail;
    private String stDate;

    public void initialize() {

        ObservableList<String> obList = FXCollections.observableArrayList();

        obList.add("Male");
        obList.add("Female");

        cmbGen.setItems(obList);

        try {
            EmployeeDto dto = employeeBO.searchEmp(EmpEmail);

            txtEmail.setText(dto.getEmail());
            txtNIC.setText(dto.getNIC());
            txtFirstName.setText(dto.getFirst_name());
            txtLastName.setText(dto.getLast_name());
            txtAddress.setText(dto.getAddress());
            txtPosition.setText(dto.getPosition());
            calDOB.setPromptText(dto.getDob());
            txtTel.setText(dto.getTel());
            cmbGen.setPromptText(dto.getGender());
            txtEmpDetails.setText(dto.getEmp_detail());
            this.stDate = dto.getStart_date();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        var dto = new EmployeeDto(txtEmail.getText(), txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPosition.getText(), stDate, cmbGen.getPromptText(), calDOB.getPromptText(), txtTel.getText(), txtEmpDetails.getText());

        if (validation.getValidation("Employee", dto)) {
            System.out.println("1");
            try {
                System.out.println("2");
                if (employeeBO.updateEmployee(dto)) {
                    System.out.println("3");
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }
}

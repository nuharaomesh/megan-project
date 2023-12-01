package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.model.EmployeeModel;

import java.sql.SQLException;
import java.util.List;

public class ServiceFormController {

    @FXML
    private DatePicker calEndDate;

    @FXML
    private DatePicker calStartDate;

    @FXML
    private JFXComboBox<String> cmbPM;

    @FXML
    private TextArea txtServiceDet;

    @FXML
    private TextField txtServiceType;

    private EmployeeModel employeeModel = new EmployeeModel();

    public void initialize() {
        loadPm();
    }

    public void loadPm() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> idList = employeeModel.getPM();

            for (EmployeeDto dto: idList) {
                obList.add(dto.getFirst_name());
            }
            cmbPM.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnServiceOnAction(ActionEvent event) {

    }

}

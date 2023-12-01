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
import lk.ijse.dto.ServiceDto;
import lk.ijse.model.EmployeeModel;
import lk.ijse.model.ServiceModel;

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
    private String prpId = PropertyFormController.prpId;

    private EmployeeModel employeeModel = new EmployeeModel();
    private ServiceModel model = new ServiceModel();

    public void initialize() {
        loadPm();
    }

    public void loadPm() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> idList = employeeModel.getPM();

            for (EmployeeDto dto: idList) {
                obList.add(dto.getNIC());
            }
            cmbPM.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnServiceOnAction(ActionEvent event) {

        var dto = new ServiceDto(prpId, cmbPM.getValue(), String.valueOf(calStartDate.getValue()), String.valueOf(calEndDate.getValue()), txtServiceDet.getText(), txtServiceType.getText());

        System.out.println(calStartDate.getPromptText());
        System.out.println(calStartDate.getValue());
        try {
            if (model.saveService(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Service Added!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}

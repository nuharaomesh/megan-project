package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ServiceBO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.ServiceDto;

import java.sql.SQLException;
import java.util.HashSet;

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
    private ServiceBO serviceBO = (ServiceBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.SERVICE);

    public void initialize() {
        loadPm();
    }

    public void loadPm() {

        try {
            HashSet<EmployeeDto> idList = serviceBO.getPrpMang();

            for (EmployeeDto dto : idList) {
                cmbPM.getItems().add(dto.getNIC());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnServiceOnAction(ActionEvent event) {

        var dto = new ServiceDto(prpId, cmbPM.getValue(), String.valueOf(calStartDate.getValue()), String.valueOf(calEndDate.getValue()), txtServiceDet.getText(), txtServiceType.getText());

        try {
            if (serviceBO.saveService(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Service Added!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

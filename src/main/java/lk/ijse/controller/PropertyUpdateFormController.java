package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.PropertyBO;
import lk.ijse.bo.custom.impl.PropertyBOImpl;
import lk.ijse.dto.PropertyDto;
import lk.ijse.plugin.Validation;
import net.sf.jasperreports.engine.util.JRStyledText;

import java.sql.SQLException;

public class PropertyUpdateFormController {

    public TextField txtRoomC;
    @FXML
    private Label lblPropertyName;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPropertyName;
    @FXML
    private TextField txtPropertyType;
    @FXML
    private TextField txtRent;
    private String prpId = PropertyFormController.prpId;
    private PropertyBO propertyBO = new PropertyBOImpl();
    private Validation validation = new Validation();

    public void initialize() {
        searchPrp(prpId);
    }

    private void searchPrp(String prpId) {

        PropertyDto dto = null;

        try {
            dto = propertyBO.searchPrp(prpId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        txtAddress.setText(dto.getAddress());
        txtPropertyName.setText(dto.getName());
        txtPropertyType.setText(dto.getProperty_type());
        txtRent.setText(dto.getRent_amount());
        lblPropertyName.setText(dto.getName());
        txtRoomC.setText(dto.getRoomCount());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        PropertyDto dto = new PropertyDto(prpId, txtPropertyName.getText(), txtAddress.getText(), txtPropertyType.getText(), txtRent.getText(), txtRoomC.getText());

        try {
            if (validation.getValidation("Property", dto)) {
                if (propertyBO.updatePrp(dto)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Property updated!!").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

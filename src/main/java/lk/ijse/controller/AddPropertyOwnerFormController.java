package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyOwnerModel;

import java.sql.SQLException;
import java.util.Optional;

public class AddPropertyOwnerFormController {

    @FXML
    private TextField txtPrpOwnerId;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTel;
    @FXML
    private AnchorPane rootNode;
    private PropertyOwnerModel ownerModel = new PropertyOwnerModel();

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        var dto = new PropertyOwnerDto(txtPrpOwnerId.getText(), txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtTel.getText());

        boolean isSaved = false;
        try {

            isSaved = ownerModel.savePrpOwner(dto);
            if (isSaved) {

                ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Owner saved!!", ok).showAndWait();

                if (type.orElse(ok) == ok) {
                    // Need to close this page after saving Property owner
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
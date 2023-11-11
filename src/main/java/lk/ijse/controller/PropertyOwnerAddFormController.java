package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.model.PropertyOwnerModel;

import java.sql.SQLException;
import java.util.Optional;

public class PropertyOwnerAddFormController {

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

        try {

            boolean isSaved = ownerModel.savePrpOwner(dto);

            if (isSaved) {

                ButtonType yes = new ButtonType("no", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("yes", ButtonBar.ButtonData.CANCEL_CLOSE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Property owner saved!! \nDo you want add another ?", yes, no).showAndWait();

                if (type.orElse(no) == yes) {
                    Stage stage = (Stage) this.rootNode.getScene().getWindow();
                    stage.close();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
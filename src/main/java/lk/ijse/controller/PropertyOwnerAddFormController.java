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

        boolean isSaved = false;
        try {

            isSaved = ownerModel.savePrpOwner(dto);
            if (isSaved) {

                ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Owner saved!!", ok).showAndWait();

                if (type.orElse(ok) == ok) {
                    Scene scene = new Scene(rootNode);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.close();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
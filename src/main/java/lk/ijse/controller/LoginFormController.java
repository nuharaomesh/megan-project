package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.UserDto;
import lk.ijse.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label lblWUP;

    @FXML
    void btnCAAOnAction(ActionEvent event) {

    }
    private UserModel logModel = new UserModel();
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException {

        var UserDto = new UserDto(txtUsername.getText(), txtPassword.getText());

        boolean isTrue = logModel.searcheUser(UserDto);

        if (txtUsername.getText().equals("") && txtPassword.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "There is a blank", ButtonType.OK).showAndWait();
            lblWUP.setText("");
            return;
        }
        if (isTrue) {
            Parent rootNode = FXMLLoader.load(getClass().getResource("/view/main_form.fxml"));
            Scene scene = new Scene(rootNode);

            Stage stage = (Stage) this.rootNode.getScene().getWindow();

            stage.setScene(scene);
            stage.centerOnScreen();
        } else {
            lblWUP.setText("Wrong username or password");
        }
    }
}

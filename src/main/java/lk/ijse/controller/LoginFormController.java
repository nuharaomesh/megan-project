package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.dto.UserDto;
import lk.ijse.model.LoginModel;

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
    private LoginModel logModel = new LoginModel();
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        var UserDto = new UserDto(username, password);

        boolean isTrue = logModel.searcheUser(UserDto);

        if (isTrue) {

            Parent rootNode = FXMLLoader.load(getClass().getResource("/view/main_form.fxml"));
            Scene scene = new Scene(rootNode);

            Stage stage = (Stage) this.rootNode.getScene().getWindow();

            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.centerOnScreen();
        } else {
            lblWUP.setText("Wrong username or password");
        }
    }
}

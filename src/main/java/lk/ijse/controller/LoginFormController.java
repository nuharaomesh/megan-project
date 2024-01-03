package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.LoginBO;
import lk.ijse.bo.custom.impl.LoginBOImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.plugin.GMailer;

import java.io.IOException;

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
    private JFXButton btnLogin;
    private LoginBO loginBO = (LoginBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.LOGIN);

    public void initialize() {
        btnLogin.setCursor(Cursor.HAND);
    }
    @FXML
    void btnCAAOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/signin_form.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    void btnLoginOnAction(ActionEvent event) throws Exception {

        var dto = new UserDto(txtUsername.getText(), txtPassword.getText());

        boolean isTrue = loginBO.searchUser(dto);

        if (txtUsername.getText().equals("") && txtPassword.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "There is a blank", ButtonType.OK).showAndWait();
            lblWUP.setText("");
            return;
        }
        if (isTrue) {

            GMailer gMailer = new GMailer();
            gMailer.setEmail(txtUsername.getText());
            gMailer.senMail("Welcome!!", "Hello again!!\nyou log the Megan..");
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

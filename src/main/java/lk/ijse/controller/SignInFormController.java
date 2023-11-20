package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SignInFormController {

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPassWord;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtUserName;

    @FXML
    private JFXButton btnBack;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnSignIn;

    public void initialize() {
        btnSignIn.setCursor(Cursor.HAND);
        btnBack.setCursor(Cursor.HAND);
    }
    @FXML
    void btnSignInOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}

package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.UserDto;
import lk.ijse.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

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

    private String userId;

    private UserModel userModel = new UserModel();

    @FXML
    private JFXButton btnSignIn;

    public void initialize() {
        btnSignIn.setCursor(Cursor.HAND);
        btnBack.setCursor(Cursor.HAND);
        generateUserID();
        System.out.println(userId);
    }

    private void generateUserID() {
        try {
            this.userId = userModel.getUserCount();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {

        if (txtPassWord.getText().equals(txtConfirmPassword.getText())) {

            var dto = new UserDto(txtUserName.getText(), userId, txtPassWord.getText(), txtFirstName.getText(), txtLastName.getText(), txtPosition.getText());

            try {
                if (userModel.saveUser(dto)) {

                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

                    Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Added!!", ok).showAndWait();
                    Stage stage = (Stage) this.root.getScene().getWindow();
                    stage.close();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).showAndWait();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Confirmation password not equal with fist one!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).show();
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}

package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyOwnerForm {

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFName;

    @FXML
    private TableColumn<?, ?> colProperty;

    @FXML
    private TableColumn<?, ?> colTele;

    @FXML
    private TableView<?> tblPropertyOwner;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblPropertyName;

    @FXML
    private Label lblTel;

    @FXML
    void btnAddPropertyOwnerOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyowneradd_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Add a Property Owner");

        stage.show();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/propertyownerupdate_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Update property owner!!");

        stage.show();
    }
}

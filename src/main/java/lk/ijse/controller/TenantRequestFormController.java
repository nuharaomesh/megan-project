package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class TenantRequestFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colPropertyType;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colTenantName;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFIrstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblTel;

    @FXML
    private TableView<?> tblTenant;

    @FXML
    private Text txtRequestMail;

    @FXML
    private TextArea txtResponseMail;

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }
}

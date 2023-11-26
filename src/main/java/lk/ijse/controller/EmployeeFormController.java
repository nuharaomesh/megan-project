package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.tm.EmployeeTm;
import lk.ijse.model.EmployeeModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EmployeeFormController {

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblEmail;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblPosition;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colEmail;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colPosition;
    @FXML
    private Label lblTRAddress;
    @FXML
    private Label lblTREmail;
    @FXML
    private Label lblTRName;
    @FXML
    private Label lblTRPosition;
    @FXML
    public TableView<EmployeeTm> tblEmployee;
    private EmployeeModel empModel = new EmployeeModel();

    public void initialize() {
        setCellValueFactory();
        loadAllEmp();
        tableListener();
    }

    private void setCellValueFactory() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

    }

    private void loadAllEmp() {

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = empModel.getAllEmpl();

            for (EmployeeDto dto: dtoList) {
                obList.add(
                        new EmployeeTm(
                                dto.getFirst_name(),
                                dto.getAddress(),
                                dto.getEmail(),
                                dto.getPosition()
                        )
                );
            }
            tblEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void tableListener() {

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            try {
                EmployeeDto dto = empModel.searchEmp(newValue.getEmail());
                setData(newValue, dto.getLast_name());
                lblVisual(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void setData(EmployeeTm row, String lastName) {
        lblPosition.setText(row.getPosition());
        lblFirstName.setText(row.getFirst_name());
        lblLastName.setText(lastName);
        lblAddress.setText(row.getAddress());
        lblEmail.setText(row.getEmail());
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        if (!lblPosition.getText().equals("")) {

            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want remove Employee", yes, no).showAndWait();

            if (type.orElse(no) == yes) {

                try {

                    if (empModel.deleteEmp(lblEmail.getText())) {
                        ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        initialize();
                        lblVisual(false);
                        clearLbl();
                        new Alert(Alert.AlertType.CONFIRMATION, "Employee removed!!", ok).showAndWait();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Select Employee first!!", new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE)).show();
        }
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/employeeadd_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Add new Employee.");
        stage.setOnCloseRequest(
            new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    loadAllEmp();
                }
            });
        stage.show();
    }

    public void btnEditEmpOnAction(ActionEvent event) throws IOException {

        if (!lblEmail.getText().equals("")) {
            EmployeeEditFormController.EmpEmail = lblEmail.getText();
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/employeeedit_form.fxml"))));
            stage.centerOnScreen();
            stage.setTitle("Update Employee detail.");

            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Choose Employee first!!").show();
        }
    }

    private void lblVisual(boolean visual) {

        if (visual) {
            lblTRAddress.setStyle("visibility: false");
            lblTRName.setStyle("visibility: false");
            lblTRPosition.setStyle("visibility: false");
            lblTREmail.setStyle("visibility: false");
        } else {
            lblTRAddress.setStyle("visibility: true");
            lblTRName.setStyle("visibility: true");
            lblTRPosition.setStyle("visibility: true");
            lblTREmail.setStyle("visibility: true");
        }
    }

    private void clearLbl() {
        lblPosition.setText("");
        lblFirstName.setText("");
        lblLastName.setText("");
        lblEmail.setText("");
        lblAddress.setText("");
    }
}

package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.model.EmployeeModel;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.TenantModel;

import java.sql.SQLException;

public class DashboardFormController {

    @FXML
    private StackedBarChart<?, ?> chartPropertyRent;
    @FXML
    private TableColumn<?, ?> colPrpName;
    @FXML
    private Label lblMontIncome;
    @FXML
    private Label lblPaidRent;
    @FXML
    private Label lblPendingRent;
    @FXML
    private Label lblPrpOwnCount;
    @FXML
    private Label lblServEndDate;
    @FXML
    private Label lblServStartDate;
    @FXML
    private Label lblServType;
    @FXML
    private Label lblServiceCount;
    @FXML
    private TableView<?> tblService;
    public Label lblPropertyC;
    public Label lblTenantC;
    public Label lblEmployeeC;

    private EmployeeModel employeeModel = new EmployeeModel();
    private TenantModel tenantModel = new TenantModel();
    private PropertyModel model = new PropertyModel();

    public void initialize() {
        setLblValues();
    }

    private void setLblValues() {
        
        try {
            lblPropertyC.setText(model.getPrpCount());
            lblTenantC.setText(tenantModel.getTntCount());
            lblEmployeeC.setText(employeeModel.getEmCount());
            
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }
}

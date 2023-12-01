package lk.ijse.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.model.EmployeeModel;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.TenantModel;

import java.sql.SQLException;

public class DashboardFormController {
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
}

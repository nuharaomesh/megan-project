package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.PropertyBO;
import lk.ijse.bo.custom.TenantBO;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.model.EmployeeModel;
import lk.ijse.model.PropertyModel;
import lk.ijse.model.TenantModel;
import net.sf.jasperreports.charts.type.ScaleTypeEnum;

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

    /*private EmployeeModel employeeModel = new EmployeeModel();
    private TenantModel tenantModel = new TenantModel();
    private PropertyModel model = new PropertyModel();*/

    private EmployeeBO employeeBO = (EmployeeBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.EMPLOYEE);
    private TenantBO tenantBO = (TenantBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.TENANT);
    private PropertyBO propertyBO = (PropertyBO) BOFactory.getDaoFactory().getTypes(BOFactory.BOTypes.PROPERTY);

    public void initialize() {
        setLblValues();
    }

    private void setLblValues() {

        try {
            lblPropertyC.setText(propertyBO.getPrpCount());
            lblTenantC.setText(tenantBO.getTntCount());
            lblEmployeeC.setText(employeeBO.getEmCount());

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }
}

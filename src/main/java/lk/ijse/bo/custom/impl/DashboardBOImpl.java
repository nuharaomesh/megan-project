package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DashboardBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.dao.custom.TenantDAO;

import java.sql.SQLException;

public class DashboardBOImpl implements DashboardBO {

    private PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY);
    private TenantDAO tenantDAO = (TenantDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.TENANT);
    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public String getPrpCount() throws SQLException, ClassNotFoundException {
        return propertyDAO.getCount();
    }

    @Override
    public String getTntCount() throws SQLException, ClassNotFoundException {
        return tenantDAO.getCount();
    }

    @Override
    public String getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmpCount();
    }
}

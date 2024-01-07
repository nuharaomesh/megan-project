package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.sql.SQLException;

public interface DashboardBO extends SuperBO {

    String getPrpCount() throws SQLException, ClassNotFoundException;
    String getTntCount() throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException, ClassNotFoundException;
}

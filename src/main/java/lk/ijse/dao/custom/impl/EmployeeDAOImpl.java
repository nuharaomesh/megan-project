package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", entity.getEmail(), entity.getNIC(), entity.getFirst_name(), entity.getLast_name(), entity.getAddress(), entity.getPosition(), entity.getStart_date(), entity.getGender(), entity.getDob(), entity.getTel(), entity.getEmp_detail());
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Employee search(String mail) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("SELECT * FROM Employee WHERE email = ?", mail);
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

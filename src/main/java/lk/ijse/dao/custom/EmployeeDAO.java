package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.HashSet;

public interface EmployeeDAO extends CrudDAO<Employee> {

    String getEmpCount() throws SQLException, ClassNotFoundException;
    HashSet<Employee> getAll() throws SQLException, ClassNotFoundException;
    HashSet<Employee> getPM() throws SQLException, ClassNotFoundException;
}

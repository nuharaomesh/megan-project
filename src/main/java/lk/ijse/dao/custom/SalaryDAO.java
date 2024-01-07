package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Salary;

import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<Salary> {

    String genId() throws SQLException, ClassNotFoundException;
    String getSalary(String email) throws SQLException, ClassNotFoundException;
}

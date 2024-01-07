package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", entity.getEmail(), entity.getNIC(), entity.getFirst_name(), entity.getLast_name(), entity.getAddress(), entity.getPosition(), entity.getStart_date(), entity.getGender(), entity.getDob(), entity.getTel(), entity.getEmp_detail());
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("UPDATE Employee SET email = ?, first_name = ?, last_name = ?, address = ?, position = ?, gender = ?, dob = ?, tel = ?, emp_detail = ? WHERE NIC = ?", entity.getEmail(), entity.getFirst_name(), entity.getLast_name(), entity.getAddress(), entity.getPosition(), entity.getGender(), entity.getDob(), entity.getTel(), entity.getEmp_detail(), entity.getNIC());
    }

    @Override
    public boolean delete(String email) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("DELETE FROM Employee WHERE email = ?", email);
    }

    @Override
    public Employee search(String mail) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Employee WHERE email = ?", mail);

        Employee entity = null;

        if (rst.next()) {
            entity = new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)
            );
        }
        return entity;
    }

    @Override
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getEmpCount() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Employee");

        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count + "";
    }

    @Override
    public HashSet<Employee> getAll() throws SQLException, ClassNotFoundException{

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Employee");

        HashSet<Employee> list = new HashSet<>();

        while (rst.next()) {
            list.add(
                    new Employee(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getString(7),
                            rst.getString(8),
                            rst.getString(9),
                            rst.getString(10),
                            rst.getString(11)
                    )
            );
        }
        return list;
    }

    @Override
    public HashSet<Employee> getPM() throws SQLException, ClassNotFoundException{

        ResultSet rst =  SQLUtil.setQue("SELECT * FROM Employee WHERE position = ?", "Property manager");
        HashSet<Employee> list = new HashSet<>();

        while (rst.next()) {
            list.add(
                    new Employee(
                            rst.getString(2)
                    )
            );
        }
        return list;
    }
}

package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.entity.Salary;

import java.sql.SQLException;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public boolean save(Salary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Salary VALUES (?, ?, ?, ?)", entity.getSal_id(), entity.getAmount(), entity.getPayment_date(), entity.getEmNIC());
    }

    @Override
    public boolean update(Salary dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Salary search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}

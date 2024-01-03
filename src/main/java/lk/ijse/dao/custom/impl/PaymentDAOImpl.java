package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;

import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Payment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

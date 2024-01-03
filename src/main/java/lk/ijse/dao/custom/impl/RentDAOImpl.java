package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Rent;

import java.sql.SQLException;

public class RentDAOImpl implements RentDAO {

    @Override
    public boolean save(Rent dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Rent dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Rent search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

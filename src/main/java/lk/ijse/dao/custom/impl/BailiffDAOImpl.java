package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.BailiffDAO;
import lk.ijse.entity.Bailiff;

import java.sql.SQLException;

public class BailiffDAOImpl implements BailiffDAO {

    @Override
    public boolean save(Bailiff dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Bailiff dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Bailiff search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

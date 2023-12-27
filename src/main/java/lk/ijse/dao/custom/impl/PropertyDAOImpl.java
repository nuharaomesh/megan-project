package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.entity.Property;

import java.sql.SQLException;

public class PropertyDAOImpl implements PropertyDAO {
    @Override
    public boolean save(Property dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Property dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Property search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

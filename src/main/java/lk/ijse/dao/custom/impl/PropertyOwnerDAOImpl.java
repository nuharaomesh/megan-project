package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.PropertyOwnerDAO;
import lk.ijse.entity.PropertyOwner;

import java.sql.SQLException;

public class PropertyOwnerDAOImpl implements PropertyOwnerDAO {
    @Override
    public boolean save(PropertyOwner dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PropertyOwner dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PropertyOwner search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

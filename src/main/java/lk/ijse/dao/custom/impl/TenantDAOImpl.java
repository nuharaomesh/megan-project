package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.TenantDAO;
import lk.ijse.entity.Tenant;

import java.sql.SQLException;

public class TenantDAOImpl implements TenantDAO {

    @Override
    public boolean save(Tenant dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Tenant dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Tenant search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

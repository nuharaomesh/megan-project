package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.AgreementDAO;
import lk.ijse.entity.Agreement;

import java.sql.SQLException;

public class AgreementDAOImpl implements AgreementDAO {
    
    @Override
    public boolean save(Agreement dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Agreement dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Agreement search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

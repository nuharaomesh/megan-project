package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BailiffDAO;
import lk.ijse.entity.Bailiff;

import java.sql.SQLException;

public class BailiffDAOImpl implements BailiffDAO {

    @Override
    public boolean save(Bailiff entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Bailiff VALUES (?, ?, ?, ?, ?, ?)", entity.getBail_id(), entity.getFirst_name(), entity.getLast_name(), entity.getOffice_address(), entity.getEmail(), entity.getTel_no());
    }

    @Override
    public boolean update(Bailiff entity) throws SQLException, ClassNotFoundException {
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
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

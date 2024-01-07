package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.AgreementAndBailiffDAO;
import lk.ijse.entity.AgreementAndBailiff;

import java.sql.SQLException;

public class AgreementAndBailiffDAOImpl implements AgreementAndBailiffDAO {

    @Override
    public boolean save(AgreementAndBailiff dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO AgreementBailiff VALUES (?, ?)", dto.getAgree_id(), dto.getBail_id());
    }

    @Override
    public boolean update(AgreementAndBailiff dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public AgreementAndBailiff search(String value) throws SQLException, ClassNotFoundException {
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

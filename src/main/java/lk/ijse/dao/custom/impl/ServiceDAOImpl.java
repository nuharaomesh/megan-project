package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ServiceDAO;
import lk.ijse.entity.Service;

import java.sql.SQLException;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public boolean save(Service entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Service VALUES(?, ?, ?, ?, ?, ?)", entity.getProp_id(), entity.getNIC(), entity.getService_startDate(), entity.getService_endDate(), entity.getService_desc(), entity.getService_type());
    }

    @Override
    public boolean update(Service dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Service search(String value) throws SQLException, ClassNotFoundException {
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

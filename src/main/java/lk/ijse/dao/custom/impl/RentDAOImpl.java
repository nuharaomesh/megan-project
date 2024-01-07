package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentDAOImpl implements RentDAO {

    @Override
    public boolean save(Rent entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Rent VALUES (?, ?, ?, ?, ?, ?, ?)", entity.getRent_id(), entity.getDate(), entity.getAmount(), entity.getEmNIC(), entity.getPay_id(), entity.getTenant_id(), entity.getProp_id());
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
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLUtil.setQue("SELECT rent_id FROM Rent ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("rent_id");
            int agreementId = Integer.parseInt(id.replace("R00-", "")) + 1;
            return String.format("R00-%03d", agreementId);
        } else {
            return "R00-001";
        }
    }
}

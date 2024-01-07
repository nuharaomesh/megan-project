package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.AgreementDAO;
import lk.ijse.entity.Agreement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreementDAOImpl implements AgreementDAO {
    
    @Override
    public boolean save(Agreement entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Agreement VALUES (?, ?, ?, ?)", entity.getAgree_id(), entity.getLease_startDate(), entity.getLease_endDate(), entity.getRent_id());
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.setQue("SELECT agree_id FROM Agreement ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("agree_id");
            int agreementId = Integer.parseInt(id.replace("A00-", "")) + 1;
            return String.format("A00-%03d", agreementId);
        } else {
            return "A00-001";
        }
    }

    @Override
    public boolean update(Agreement entity) throws SQLException, ClassNotFoundException {
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
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }
}

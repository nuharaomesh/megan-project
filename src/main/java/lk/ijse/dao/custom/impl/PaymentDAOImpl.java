package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public String genId() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLUtil.setQue("SELECT pay_id FROM Payment ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("pay_id");
            int agreementId = Integer.parseInt(id.replace("PY00-", "")) + 1;
            return String.format("PY00-%03d", agreementId);
        } else {
            return "PY00-001";
        }
    }

    @Override
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Payment VALUES (?, ?, ?)", entity.getPay_id(), entity.getAmount(), entity.getPayment_date());
    }

    @Override
    public boolean update(Payment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }
}

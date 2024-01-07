package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.entity.Custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public HashSet<Custom> getAllPrpOwns() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT po.first_name, po.email, po.tel_no, p.property_name FROM Property_owner po JOIN Property p ON po.prpOwner_id = p.prpOwner_id");

        HashSet<Custom> set = new HashSet<>();
        while (rst.next()) {
            set.add(
                    new Custom(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4)
                    )
            );
        }
        return set;
    }

    @Override
    public Custom getTntDet() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT t.first_name, t.last_name, t.email, t.tel_no, r.amount, p.property_type FROM Tenant t JOIN Rent r ON t.tenant_id = r.tenant_id JOIN Property p ON p.prop_id = r.prop_id");

        Custom entity = null;
        if (rst.next()) {
            entity = new Custom(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    String.valueOf(rst.getDouble(5)),
                    rst.getString(6)
            );
        }
        return entity;
    }

    @Override
    public Custom getTntLeaseDate(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.setQue("SELECT t.tenant_id, a.lease_startDate, a.lease_endDate FROM Tenant t JOIN Rent r ON t.tenant_id = r.tenant_id JOIN Agreement a ON a.rent_id = r.rent_id WHERE t.tenant_id = ?", id);

        Custom entity = null;
        if (resultSet.next()) {
            entity = new Custom(
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }
        return entity;
    }
}

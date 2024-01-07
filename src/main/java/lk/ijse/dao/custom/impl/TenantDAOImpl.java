package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.TenantDAO;
import lk.ijse.entity.Tenant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class TenantDAOImpl implements TenantDAO {

    @Override
    public boolean save(Tenant entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Tenant VALUES(?, ?, ?, ?, ?)", entity.getTenant_id(), entity.getFirst_name(), entity.getLast_name(), entity.getEmail(), entity.getTel_no());
    }

    @Override
    public boolean update(Tenant entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("UPDATE Tenant SET first_name = ?, last_name = ?, email = ?, tel_no = ? WHERE tenant_id = ?", entity.getFirst_name(), entity.getFirst_name(), entity.getEmail(), entity.getTel_no(), entity.getTenant_id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("DELETE FROM Tenant WHERE email = ?", id);
    }

    @Override
    public Tenant search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Tenant WHERE tenant_id = ?", id);

        Tenant entity = null;

        if (rst.next())
            entity = new Tenant(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5)
        );
        return entity;
    }

    @Override
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public HashSet<Tenant> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Tenant");

        HashSet<Tenant> set = new HashSet<>();

        while (rst.next()) {
            set.add(
                    new Tenant(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)
                    )
            );
        }
        return set;
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Tenant");

        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count + "";
    }
}

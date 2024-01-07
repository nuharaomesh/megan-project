package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PropertyOwnerDAO;
import lk.ijse.entity.PropertyOwner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class PropertyOwnerDAOImpl implements PropertyOwnerDAO {

    @Override
    public boolean save(PropertyOwner entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Property_owner VAlUES(?, ?, ?, ?, ?)", entity.getEmail(), entity.getPrpOwner_id(), entity.getFirst_name(), entity.getLast_name(), entity.getTel_no());
    }

    @Override
    public boolean update(PropertyOwner entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("UPDATE Property_owner SET email = ?, first_name = ?, last_name = ?, tel_no = ? WHERE prpOwner_id = ?", entity.getEmail(), entity.getFirst_name(), entity.getLast_name(), entity.getTel_no(), entity.getPrpOwner_id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PropertyOwner search(String email) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Property_owner WHERE email = ?", email);

        PropertyOwner entity = null;

        if (rst.next()) entity = new PropertyOwner(
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
    public HashSet<PropertyOwner> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Property_owner");

        HashSet<PropertyOwner> set = new HashSet<>();

        while (rst.next()) {
            set.add(
                    new PropertyOwner(
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
}

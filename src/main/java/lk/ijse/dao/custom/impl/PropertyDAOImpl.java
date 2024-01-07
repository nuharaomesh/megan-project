package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.entity.Property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropertyDAOImpl implements PropertyDAO {

    @Override
    public ArrayList<Property> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Property WHERE status = ?", "not");

        ArrayList<Property> list = new ArrayList<>();

        while (rst.next()) {
            list.add(
                    new Property(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4)
                    )
            );
        }
        return list;
    }

    @Override
    public boolean save(Property entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Property VALUES(?, ?, ?, ?, ?, ?, ?, ?)", entity.getProp_id(), entity.getName(), entity.getAddress(), entity.getProperty_type(), entity.getRent_amount(), entity.getRoomCount(), entity.getPrpOwner_id(), "not");
    }

    @Override
    public boolean update(Property entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("UPDATE Property SET property_name = ?, address = ?, property_type = ?, rent_amount = ?, room = ? WHERE prop_id = ?", entity.getName(), entity.getAddress(), entity.getProperty_type(), entity.getRent_amount(), entity.getRoomCount(), entity.getProp_id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("DELETE FROM Property WHERE prop_id = ?", id);
    }

    @Override
    public Property search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Property WHERE prop_id = ?", id);

        Property entity = null;
        if (rst.next()) {
            entity = new Property(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }
        return entity;
    }

    @Override
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.setQue("SELECT prop_id FROM Property ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("prop_id");
            int agreementId = Integer.parseInt(id.replace("PR00-", "")) + 1;
            return String.format("PR00-%03d", agreementId);
        } else {
            return "PR00-001";
        }
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Property");

        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count + "";
    }

    @Override
    public boolean changeSts(String propId) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("UPDATE Property SET status = ? WHERE prop_id = ?", "rent", propId);
    }
}

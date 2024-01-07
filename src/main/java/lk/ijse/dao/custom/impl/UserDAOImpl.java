package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)", entity.getUsername(), entity.getUser_id(), entity.getPassword(), entity.getFirst_name(), entity.getLast_name(), entity.getPosition());
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLUtil.setQue("SELECT user_id FROM User ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("user_id");
            int agreementId = Integer.parseInt(id.replace("U00-", "")) + 1;
            return String.format("U00-%03d", agreementId);
        } else {
            return "U00-001";
        }
    }

    @Override
    public boolean checkCred(User entity) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM User WHERE username = ?", entity.getUsername());

        if (rst.next()) {
            if (entity.getPassword().equals(rst.getString(3))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User search(String username) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String email) throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.setQue("SELECT * FROM User WHERE username = ?", email);
        return rst.next();
    }
}

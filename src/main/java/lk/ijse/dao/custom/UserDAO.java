package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {

    String genId() throws SQLException, ClassNotFoundException;
    boolean checkCred(User entity) throws SQLException, ClassNotFoundException;
}

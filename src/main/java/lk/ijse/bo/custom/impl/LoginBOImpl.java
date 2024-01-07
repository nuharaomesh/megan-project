package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.LoginBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {

    private UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.USER);

    @Override
    public boolean existUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDAO.checkCred(new User(dto.getUsername(), dto.getPassword()));
    }
}

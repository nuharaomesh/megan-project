package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SignInBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class SignInBOImpl implements SignInBO {

    private UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUsername(), dto.getUser_id(), dto.getPassword(), dto.getFirst_name(), dto.getLast_name(), dto.getPosition()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return userDAO.genId();
    }
}

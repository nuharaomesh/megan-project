package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SignInBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public class SignInBOImpl implements SignInBO {

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return null;
    }
}

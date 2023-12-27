package lk.ijse.bo.custom;

import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface SignInBO {

    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;
    String getId() throws SQLException, ClassNotFoundException;
}

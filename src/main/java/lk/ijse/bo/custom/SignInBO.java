package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface SignInBO extends SuperBO {

    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;
    String getId() throws SQLException, ClassNotFoundException;
}

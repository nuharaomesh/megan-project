package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {

    boolean existUser(UserDto dto) throws SQLException, ClassNotFoundException;
}

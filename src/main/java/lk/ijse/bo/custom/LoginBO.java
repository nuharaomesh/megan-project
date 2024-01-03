package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

public interface LoginBO extends SuperBO {

    boolean searchUser(UserDto dto);
}

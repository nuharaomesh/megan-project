package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ServiceDto;

import java.sql.SQLException;

public interface ServiceBO extends SuperBO {

    boolean saveService(ServiceDto dto) throws SQLException, ClassNotFoundException;
}

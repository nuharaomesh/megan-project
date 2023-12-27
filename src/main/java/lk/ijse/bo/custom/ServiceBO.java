package lk.ijse.bo.custom;

import lk.ijse.dto.ServiceDto;

import java.sql.SQLException;

public interface ServiceBO {

    boolean saveService(ServiceDto dto) throws SQLException, ClassNotFoundException;
}

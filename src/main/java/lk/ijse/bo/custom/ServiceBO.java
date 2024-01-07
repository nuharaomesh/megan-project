package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.ServiceDto;

import java.sql.SQLException;
import java.util.HashSet;

public interface ServiceBO extends SuperBO {

    boolean saveService(ServiceDto dto) throws SQLException, ClassNotFoundException;
    HashSet<EmployeeDto> getPrpMang() throws SQLException, ClassNotFoundException;
}

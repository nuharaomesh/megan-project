package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ServiceBO;
import lk.ijse.dto.ServiceDto;

import java.sql.SQLException;

public class ServiceBOImpl implements ServiceBO {

    @Override
    public boolean saveService(ServiceDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}

package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PropertyDto;

import java.sql.SQLException;

public interface PropertyBO extends SuperBO {

    PropertyDto searchPrp(String propertyId) throws SQLException, ClassNotFoundException;
    boolean deletePrp(String prpId) throws SQLException, ClassNotFoundException;
    boolean updatePrp(PropertyDto dto) throws SQLException, ClassNotFoundException;
}

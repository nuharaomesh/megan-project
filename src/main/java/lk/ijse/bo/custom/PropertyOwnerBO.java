package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;

import java.sql.SQLException;
import java.util.HashSet;

public interface PropertyOwnerBO extends SuperBO {

    HashSet<CustomDto> getAllPrpOwnAndPrp() throws SQLException, ClassNotFoundException;
    PropertyOwnerDto searchOwner(String email) throws SQLException, ClassNotFoundException;
    boolean savePrpOwnAndPrp(PropertyOwnerDto prpOwnDto, PropertyDto prpDto) throws SQLException, ClassNotFoundException;
    boolean updatePrpOwner(PropertyOwnerDto dto) throws SQLException, ClassNotFoundException;
    String genPrpId() throws SQLException, ClassNotFoundException;
}

package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.PrpOwnerPrppDto;

import java.sql.SQLException;
import java.util.List;

public interface PropertyOwnerBO extends SuperBO {

    List<PrpOwnerPrppDto> getAllPrpOwners() throws SQLException, ClassNotFoundException;
    PropertyOwnerDto searchOwner(String email) throws SQLException, ClassNotFoundException;
    String getId() throws SQLException, ClassNotFoundException;
    boolean savePrpOwnAndPrp(PropertyOwnerDto prpOwnDto, PropertyDto prpDto) throws SQLException, ClassNotFoundException;
    boolean updatePrpOwner(PropertyOwnerDto dto) throws SQLException, ClassNotFoundException;
}

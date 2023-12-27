package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PropertyBO;
import lk.ijse.dto.PropertyDto;

import java.sql.SQLException;

public class PropertyBOImpl implements PropertyBO {


    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public PropertyDto searchPrp(String propertyId) throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public boolean deletePrp(String prpId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updatePrp(PropertyDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}

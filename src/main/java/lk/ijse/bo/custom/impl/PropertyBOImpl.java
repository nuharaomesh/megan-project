package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PropertyBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.dto.PropertyDto;
import lk.ijse.entity.Property;

import java.sql.SQLException;

public class PropertyBOImpl implements PropertyBO {

    private PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY);

    @Override
    public PropertyDto searchPrp(String prpId) throws SQLException, ClassNotFoundException {

        Property entity =  propertyDAO.search(prpId);
        return new PropertyDto(entity.getProp_id(), entity.getName(), entity.getAddress(), entity.getProperty_type(), entity.getRent_amount(), entity.getRoomCount(), entity.getPrpOwner_id());
    }
    @Override
    public boolean deletePrp(String prpId) throws SQLException, ClassNotFoundException {
        return propertyDAO.delete(prpId);
    }

    @Override
    public boolean updatePrp(PropertyDto dto) throws SQLException, ClassNotFoundException {
        return propertyDAO.update(new Property(dto.getProp_id(), dto.getName(), dto.getAddress(), dto.getProperty_type(), dto.getRent_amount(), dto.getRoomCount(), dto.getPrpOwner_id()));
    }
}

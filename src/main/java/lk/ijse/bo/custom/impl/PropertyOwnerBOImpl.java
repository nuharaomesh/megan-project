package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PropertyOwnerBO;
import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.dao.custom.PropertyOwnerDAO;
import lk.ijse.dao.custom.impl.PropertyDAOImpl;
import lk.ijse.dao.custom.impl.PropertyOwnerDAOImpl;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.PrpOwnerPrppDto;
import lk.ijse.entity.Property;
import lk.ijse.entity.PropertyOwner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PropertyOwnerBOImpl implements PropertyOwnerBO {

    private PropertyDAO propertyDAO = new PropertyDAOImpl();
    private PropertyOwnerDAO propertyOwnerDAO = new PropertyOwnerDAOImpl();

    @Override
    public List<PrpOwnerPrppDto> getAllPrpOwners() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public PropertyOwnerDto searchOwner(String email) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean savePrpOwnAndPrp(PropertyOwnerDto prpOwnDto, PropertyDto prpDto) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        if (!propertyOwnerDAO.save(new PropertyOwner(prpOwnDto.getEmail(), prpOwnDto.getPrpOwner_id(), prpOwnDto.getFirst_name(), prpOwnDto.getLast_name(), prpOwnDto.getTel_no()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!propertyDAO.save(new Property(prpDto.getProp_id(), prpDto.getName(), prpDto.getAddress(), prpDto.getProperty_type(), prpDto.getRent_amount(), prpDto.getRoomCount()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public boolean updatePrpOwner(PropertyOwnerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}

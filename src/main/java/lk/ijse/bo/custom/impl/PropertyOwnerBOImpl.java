package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PropertyOwnerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PropertyDAO;
import lk.ijse.dao.custom.PropertyOwnerDAO;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.entity.Custom;
import lk.ijse.entity.Property;
import lk.ijse.entity.PropertyOwner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PropertyOwnerBOImpl implements PropertyOwnerBO {

    private PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY);
    private PropertyOwnerDAO propertyOwnerDAO = (PropertyOwnerDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY_OWNER);
    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.QUERY);

    @Override
    public HashSet<CustomDto> getAllPrpOwnAndPrp() throws SQLException, ClassNotFoundException { //Join

        HashSet<Custom> list = queryDAO.getAllPrpOwns();
        HashSet<CustomDto> dtoList = new HashSet<>();

        for (Custom prp: list) {
            dtoList.add(
                    new CustomDto(
                            prp.getPoFirstName(),
                            prp.getPoEmail(),
                            prp.getPoTel(),
                            prp.getPrpName()
                    )
            );
        }
        return dtoList;
    }

    @Override
    public PropertyOwnerDto searchOwner(String email) throws SQLException, ClassNotFoundException {

        PropertyOwner entity =  propertyOwnerDAO.search(email);
        return new PropertyOwnerDto(entity.getEmail(), entity.getPrpOwner_id(), entity.getFirst_name(), entity.getLast_name(), entity.getTel_no());
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
        return propertyOwnerDAO.update(new PropertyOwner(dto.getEmail(), dto.getPrpOwner_id(), dto.getFirst_name(), dto.getLast_name(), dto.getTel_no()));
    }

    @Override
    public String genPrpId() throws SQLException, ClassNotFoundException {
        return propertyDAO.genId();
    }
}

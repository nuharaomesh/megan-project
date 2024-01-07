package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.PropertyOwner;

import java.sql.SQLException;
import java.util.HashSet;

public interface PropertyOwnerDAO extends CrudDAO<PropertyOwner> {

    HashSet<PropertyOwner> getAll() throws SQLException, ClassNotFoundException;
}

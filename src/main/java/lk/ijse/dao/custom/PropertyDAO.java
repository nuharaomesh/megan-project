package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Property;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PropertyDAO extends CrudDAO<Property> {

    String genId() throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;
    boolean changeSts(String propId) throws SQLException, ClassNotFoundException;
    ArrayList<Property> getAll() throws SQLException, ClassNotFoundException;
}

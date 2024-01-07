package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Rent;

import java.sql.SQLException;

public interface RentDAO extends CrudDAO<Rent> {

    String genId() throws SQLException, ClassNotFoundException;
}

package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Custom;

import java.sql.SQLException;
import java.util.HashSet;

public interface QueryDAO extends SuperDAO {

    HashSet<Custom> getAllPrpOwns() throws SQLException, ClassNotFoundException;
    Custom getTntDet() throws SQLException, ClassNotFoundException;
    Custom getTntLeaseDate(String id) throws SQLException, ClassNotFoundException;
}

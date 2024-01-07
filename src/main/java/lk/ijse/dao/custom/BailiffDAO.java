package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Bailiff;

import java.sql.SQLException;

public interface BailiffDAO extends CrudDAO<Bailiff> {

    String genId() throws SQLException, ClassNotFoundException;
}

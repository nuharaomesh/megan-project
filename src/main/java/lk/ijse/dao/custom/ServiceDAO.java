package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Service;
import java.sql.SQLException;

public interface ServiceDAO extends CrudDAO<Service> {

    String genId() throws SQLException, ClassNotFoundException;
}

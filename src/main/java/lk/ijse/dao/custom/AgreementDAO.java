package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Agreement;

import java.sql.SQLException;

public interface AgreementDAO extends CrudDAO<Agreement> {

    String genId() throws SQLException, ClassNotFoundException;
}

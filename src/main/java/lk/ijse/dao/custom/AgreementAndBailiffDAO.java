package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.AgreementAndBailiff;

import java.sql.SQLException;

public interface AgreementAndBailiffDAO extends CrudDAO<AgreementAndBailiff> {

    String genId() throws SQLException, ClassNotFoundException;
}

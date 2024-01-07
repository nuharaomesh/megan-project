package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Tenant;

import java.sql.SQLException;
import java.util.HashSet;

public interface TenantDAO extends CrudDAO<Tenant> {

    HashSet<Tenant> getAll() throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;
}

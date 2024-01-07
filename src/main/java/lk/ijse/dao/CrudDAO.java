package lk.ijse.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {

    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    T search(String value) throws SQLException, ClassNotFoundException;
    boolean exist(String value) throws SQLException, ClassNotFoundException;
}

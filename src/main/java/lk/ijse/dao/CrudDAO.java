package lk.ijse.dao;

import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {

    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    T search(String value) throws SQLException, ClassNotFoundException;
    String genId() throws SQLException, ClassNotFoundException;
}

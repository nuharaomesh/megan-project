package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {
    public boolean saveEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Employee VALUES(?, ?, ?, ?, ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getNIC());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getPosition());

        return pstm.executeUpdate() > 0;
    }
}

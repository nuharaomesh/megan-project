package lk.ijse.model;

import javafx.beans.binding.When;
import javafx.scene.control.TextField;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.PropertyOwnerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public boolean saveEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Employee VALUES(?, ?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getNIC());
        pstm.setString(3, dto.getFirst_name());
        pstm.setString(4, dto.getLast_name());
        pstm.setString(5, dto.getAddress());
        pstm.setString(6, dto.getPosition());

        return pstm.executeUpdate() > 0;
    }

    public List<EmployeeDto> getAllEmpl() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Employee");
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<EmployeeDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new EmployeeDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;
    }

    public EmployeeDto searchEmp(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Employee WHERE email = ?");
        pstm.setString(1, email);

        ResultSet resultSet = pstm.executeQuery();

        EmployeeDto dto = null;
        if (resultSet.next()) {
            dto = new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return dto;
    }

    public boolean updateEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Employee SET NIC = ?, first_name = ?, last_name = ?, address = ?, position = ? WHERE email = ?");

        pstm.setString(1, dto.getNIC());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getPosition());
        pstm.setString(6, dto.getEmail());

        return pstm.executeUpdate() > 0;
    }
}

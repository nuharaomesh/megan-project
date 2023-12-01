package lk.ijse.model;

import javafx.beans.binding.When;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.SalaryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    SalaryModel salModel = new SalaryModel();

    public int getEmpCount() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Employee");

        ResultSet resultSet = pstm.executeQuery();
        int count = 0;

        while (resultSet.next()) {
            count++;
        }
        return count;
    }

    public boolean saveEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getNIC());
        pstm.setString(3, dto.getFirst_name());
        pstm.setString(4, dto.getLast_name());
        pstm.setString(5, dto.getAddress());
        pstm.setString(6, dto.getPosition());
        pstm.setDate(7, Date.valueOf(dto.getStart_date()));
        pstm.setString(8, dto.getGender());
        pstm.setDate(9, Date.valueOf(dto.getDob()));
        pstm.setInt(10, Integer.parseInt(dto.getTel()));
        pstm.setString(11, "");

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
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11)
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
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11)
            );
        }
        return dto;
    }

    public boolean updateEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Employee SET email = ?, first_name = ?, last_name = ?, address = ?, position = ?, gender = ?, dob = ?, tel = ?, emp_detail = ? WHERE NIC = ?");

        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getPosition());
        pstm.setString(6, dto.getGender());
        pstm.setString(7, dto.getDob());
        pstm.setInt(8, Integer.parseInt(dto.getTel()));
        pstm.setString(9, dto.getEmp_detail());
        pstm.setString(10, dto.getNIC());

        return pstm.executeUpdate() > 0;
    }

    public Boolean deleteEmp(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Employee WHERE email = ?");
        pstm.setString(1, email);

        return pstm.executeUpdate() > 0;
    }

    public boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        connection.setAutoCommit(false);

        try {
            if (saveEmp(empDto)) {
                if (salModel.savePayment(salDto)) {
                    connection.commit();
                    return true;
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    public String getNIC(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Employee WHERE email = ?");
        pstm.setString(1, email);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(2);
        }
        return null;
    }
}

package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserModel {

    public boolean searcheUser(UserDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
        pstm.setString(1, dto.getUsername());

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            if (resultSet.getString(1).equals(dto.getUsername()) && resultSet.getString(3).equals(dto.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String getUserCount() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM User");
        ResultSet resultSet = pstm.executeQuery();

        int num = 0;
        if (resultSet.next()) {
            num++;
        }
        return "U000" + (num + 1);
    }

    public boolean saveUser(UserDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)");
        pstm.setString(1, dto.getUsername());
        pstm.setString(2, dto.getUser_id());
        pstm.setString(3, dto.getPassword());
        pstm.setString(4, dto.getFirst_name());
        pstm.setString(5, dto.getLast_name());
        pstm.setString(6, dto.getPosition());

        return pstm.executeUpdate() > 0;
    }
}

package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public boolean searcheUser(UserDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM User WHERE username = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getUsername());

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            if (resultSet.getString(1).equals(dto.getUsername()) && resultSet.getString(3).equals(dto.getPassword())) {
                return true;
            }
        }
        return false;
    }
}

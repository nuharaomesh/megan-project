package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}

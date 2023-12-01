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

    public String getUserID() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT user_id FROM User ORDER BY user_id DESC LIMIT 1");
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitUserId(resultSet.getString(1));
        }
        return splitUserId(null);
    }

    private String splitUserId(String currentUserId) {
        if(currentUserId != null) {

            String[] split = currentUserId.split("U00");
            System.out.println(split[0] + ", ");
            System.out.println(split[1]);
            int id = Integer.parseInt(split[1]); //01
            id++;
            if (id < 10) {
                return "U000" + id;
            } else {
                return "U00" + id;
            }
        } else {
            return "U0001";
        }
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

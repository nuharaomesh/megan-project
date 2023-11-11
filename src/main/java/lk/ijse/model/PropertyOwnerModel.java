package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyOwnerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyOwnerModel {

    public boolean savePrpOwner(PropertyOwnerDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Property_owner VAlUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getPrpOwner_id());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getEmail());
        pstm.setString(5, dto.getTel_no());

        return pstm.executeUpdate() > 0;
    }

    public List<PropertyOwnerDto> getAllOwners() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Property_owner";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PropertyOwnerDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
              new PropertyOwnerDto(
                      resultSet.getString(1),
                      resultSet.getString(2),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5)
              )
            );
        }
        return dtoList;
    }
}

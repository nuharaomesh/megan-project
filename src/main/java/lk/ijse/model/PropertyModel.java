package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyModel {
    public boolean saveProperty(PropertyDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Property VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProp_id());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getProperty_type());
        pstm.setDouble(5, dto.getRent_amount());
        pstm.setString(6, dto.getPrpOwner_id());

        return pstm.executeUpdate() > 0;
    }

    public List<PropertyDto> getAllProperty() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Property";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PropertyDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new PropertyDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(5)
                    )
            );
        }
        return dtoList;
    }
}

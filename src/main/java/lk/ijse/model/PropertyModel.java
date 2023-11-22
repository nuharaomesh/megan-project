package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyModel {
    public boolean saveProperty(PropertyDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Property VALUES(?, ?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getProp_id());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getProperty_type());
        pstm.setDouble(5, Double.valueOf(dto.getRent_amount()));
        pstm.setString(6, dto.getPrpOwner_id());

        return pstm.executeUpdate() > 0;
    }

    public List<PropertyDto> getAllProperty() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property");
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PropertyDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new PropertyDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            String.valueOf(resultSet.getDouble(5))
                    )
            );
        }
        return dtoList;
    }

    public PropertyDto searchPrpType(String propertyId) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property WHERE prop_id = ?");
        pstm.setString(1, propertyId);

        ResultSet resultSet = pstm.executeQuery();

        PropertyDto dto = null;
        if (resultSet.next()) {

            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String type = resultSet.getString(4);
            String rent = String.valueOf(resultSet.getDouble(5));
            String prpOwId = resultSet.getString(6);

            dto = new PropertyDto(id, name, address, type, rent, prpOwId);
        }
        return dto;
    }

    public String getPrpId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property");
        ResultSet resultSet = pstm.executeQuery();

        int count = 0;

        while (resultSet.next()) {
            count++;
        }

        return "P000" + (count + 1);
    }

    public boolean deletePrp(String prpId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Property WHERE prop_id = ?");
        pstm.setString(1, prpId);

        return pstm.executeUpdate() > 0;
    }
}

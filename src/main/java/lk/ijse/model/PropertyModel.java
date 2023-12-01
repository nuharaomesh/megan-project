package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.AgreementDto;
import lk.ijse.dto.PropertyDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyModel {
    public boolean saveProperty(PropertyDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Property VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getProp_id());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getProperty_type());
        pstm.setDouble(5, Double.valueOf(dto.getRent_amount()));
        pstm.setString(6, dto.getRoomCount());
        pstm.setString(7, dto.getPrpOwner_id());
        pstm.setString(8, "not");

        return pstm.executeUpdate() > 0;
    }

    public List<PropertyDto> getAllProperty() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sta = "not";
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property WHERE status = ?");
        pstm.setString(1, sta);

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
            String roomC = resultSet.getString(6);
            String prpOwId = resultSet.getString(7);

            dto = new PropertyDto(id, name, address, type, rent, roomC, prpOwId);
        }
        return dto;
    }

    public String getPrpId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT prop_id FROM Property ORDER BY prop_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitPropertyId(resultSet.getString(1));
        }
        return splitPropertyId(null);
    }

    private String splitPropertyId(String currentPropertyId) {
        if(currentPropertyId != null) {

            String[] split = currentPropertyId.split("PO0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            if (id < 10) {
                return "PO00" + id;
            } else {
                return "PO0" + id;
            }
        } else {
            return "PO001";
        }
    }

    public boolean deletePrp(String prpId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Property WHERE prop_id = ?");
        pstm.setString(1, prpId);

        return pstm.executeUpdate() > 0;
    }

    public PropertyDto getAllValues(String prpId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property");
        ResultSet resultSet = pstm.executeQuery();

        PropertyDto dto = null;
        if (resultSet.next()) {
            dto = new PropertyDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return dto;
    }

    public boolean updatePrp(PropertyDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Property SET property_name = ?, address = ?, property_type = ?, rent_amount = ?, room = ? WHERE prop_id = ?");
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getProperty_type());
        pstm.setString(4, dto.getRent_amount());
        pstm.setString(5, dto.getRoomCount());
        pstm.setString(6, dto.getProp_id());

        return pstm.executeUpdate() > 0;
    }

    public boolean propRent(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sta = "rent";
        PreparedStatement pstm = connection.prepareStatement("UPDATE Property SET status = ? WHERE prop_id = ?");
        pstm.setString(1, sta);
        pstm.setString(2, id);

        return pstm.executeUpdate() > 0;
    }

    public String getPrpCount() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property");
        ResultSet resultSet = pstm.executeQuery();

        int count = 0;
        while (resultSet.next()) {
            count++;
        }

        return "" + count;
    }
}

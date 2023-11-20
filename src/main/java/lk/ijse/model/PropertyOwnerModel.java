package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyOwnerDto;
import lk.ijse.dto.PrpOwnerPrppDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyOwnerModel {

    public boolean savePrpOwner(PropertyOwnerDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Property_owner VAlUES(?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getPrpOwner_id());
        pstm.setString(3, dto.getFirst_name());
        pstm.setString(4, dto.getLast_name());
        pstm.setString(5, dto.getTel_no());

        return pstm.executeUpdate() > 0;
    }

    public List<PropertyOwnerDto> getAllOwners() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property_owner");
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

    public List<PrpOwnerPrppDto> getAllPrpOwners() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT po.first_name, po.email, po.tel_no, p.property_name FROM Property_owner po JOIN Property p ON po.prpOwner_id = p.prpOwner_id");
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PrpOwnerPrppDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new PrpOwnerPrppDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return dtoList;
    }

    public PropertyOwnerDto searchLsName(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property_owner WHERE email = ?");
        pstm.setString(1, email);

        ResultSet resultSet = pstm.executeQuery();

        PropertyOwnerDto dto = null;
        if (resultSet.next()) {
            dto = new PropertyOwnerDto(
                    resultSet.getString(4)
            );
        }
        return dto;
    }

    public PropertyOwnerDto getOwner(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Property_owner WHERE email = ?");
        pstm.setString(1, email);

        ResultSet resultSet = pstm.executeQuery();

        PropertyOwnerDto dto = null;
        if (resultSet.next()) {
            dto = new PropertyOwnerDto(
              resultSet.getString(1),
              resultSet.getString(2),
              resultSet.getString(3),
              resultSet.getString(4),
              resultSet.getString(5)
            );
        }
        return dto;
    }

    public boolean updatePrpOwner(PropertyOwnerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Property_owner SET email = ?, first_name = ?, last_name = ?, tel_no = ? WHERE prpOwner_id = ?");
        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getTel_no());
        pstm.setString(5, dto.getPrpOwner_id());

        return pstm.executeUpdate() > 0;
    }

    public boolean deletePrpOwner(String email) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Property_owner WHERE email = ?");
        pstm.setString(1, email);

        return pstm.executeUpdate() > 0;
    }
}

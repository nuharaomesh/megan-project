package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.TenantDto;
import lk.ijse.dto.TenantPrpDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenantModel {

    public boolean saveTenant(TenantDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Tenant VALUES(?, ?, ?, ?, ?)");

        pstm.setString(1, dto.getTenant_id());
        pstm.setString(2, dto.getFirst_name());
        pstm.setString(3, dto.getLast_name());
        pstm.setString(4, dto.getEmail());
        pstm.setString(5, dto.getTel_no());

        return pstm.executeUpdate() > 0;
    }

    public List<TenantDto> getAllTenant() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Tenant");
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<TenantDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new TenantDto(
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

    public TenantPrpDto searchTnt(String tenantId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT t.first_name, t.last_name, t.email, t.tel_no, r.amount, p.property_type FROM Tenant t JOIN Rent r ON t.tenant_id = r.tenant_id JOIN Property p ON p.prop_id = r.prop_id");

        ResultSet resultSet = pstm.executeQuery();

        TenantPrpDto dto = null;
        if (resultSet.next()) {
            dto = new TenantPrpDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6)
            );
        }
        return dto;
    }

    public TenantDto getTenant(String tenantID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Tenant WHERE tenant_id = ?");
        pstm.setString(1, tenantID);

        ResultSet resultSet = pstm.executeQuery();

        TenantDto dto = null;
        if (resultSet.next()) {
            dto = new TenantDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return dto;
    }

    public boolean updateTnt(TenantDto dto, String tenantID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Tenant SET first_name = ?, last_name = ?, email = ?, tel_no = ? WHERE tenant_id = ?");
        pstm.setString(1, dto.getFirst_name());
        pstm.setString(2, dto.getLast_name());
        pstm.setString(3, dto.getEmail());
        pstm.setString(4, dto.getTel_no());
        pstm.setString(5, tenantID);

        return pstm.executeUpdate() > 0;
    }
}

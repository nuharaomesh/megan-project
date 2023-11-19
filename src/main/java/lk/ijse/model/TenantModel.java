package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.TenantDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

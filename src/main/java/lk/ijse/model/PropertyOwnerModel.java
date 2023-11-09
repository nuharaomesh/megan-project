package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PropertyOwnerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

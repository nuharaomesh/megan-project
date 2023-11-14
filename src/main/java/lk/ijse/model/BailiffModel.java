package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.BailiffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BailiffModel {
    public boolean saveBailiff(BailiffDto bailDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Bailiff VALUES (?, ?, ?, ?, ?, ?)");

        pstm.setString(1, bailDto.getBail_id());
        pstm.setString(2, bailDto.getFirst_name());
        pstm.setString(3, bailDto.getLast_name());
        pstm.setString(4, bailDto.getOffice_address());
        pstm.setString(5, bailDto.getEmail());
        pstm.setString(6, bailDto.getTel_no());

        return pstm.executeUpdate() > 0;
    }
}

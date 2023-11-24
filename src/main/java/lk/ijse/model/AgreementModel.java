package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.AgreementDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreementModel {
    public boolean saveAgreement(AgreementDto agreementDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Agreement VALUES (?, ?, ?, ?)");

        pstm.setString(1, agreementDto.getAgree_id());
        pstm.setString(2, agreementDto.getLease_startDate());
        pstm.setString(3, agreementDto.getLease_endDate());
        pstm.setString(4, agreementDto.getRent_id());

        return pstm.executeUpdate() > 0;
    }

    public String genAgID() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT agree_id FROM Agreement ORDER BY agree_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("A00");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "A000" + id;
        } else {
            return "A0001";
        }
    }
}

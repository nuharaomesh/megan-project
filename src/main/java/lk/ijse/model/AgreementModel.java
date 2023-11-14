package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.AgreementDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}

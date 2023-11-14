package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.AgreementBailiffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgreementAndBailiffModel {
    public boolean saveBailNAgreement(AgreementBailiffDto agAndBailDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO AgreementBailiff VALUES (?, ?)");

        pstm.setString(1, agAndBailDto.getAgree_id());
        pstm.setString(2, agAndBailDto.getBail_id());

        return pstm.executeUpdate() > 0;
    }
}

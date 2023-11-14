package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentModel {
    public boolean savePayment(PaymentDto paymentDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Payment VALUES (?, ?, ?)");

        pstm.setString(1, paymentDto.getPay_id());
        pstm.setString(2, paymentDto.getAmount());
        pstm.setString(3, paymentDto.getPayment_date());

        return pstm.executeUpdate() > 0;
    }
}

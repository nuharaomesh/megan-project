package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public String genPayID() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT pay_id FROM Payment ORDER BY pay_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("P00");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "P000" + id;
        } else {
            return "P0001";
        }
    }
}

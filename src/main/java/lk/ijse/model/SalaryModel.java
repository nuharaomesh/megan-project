package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.SalaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryModel {

    public boolean savePayment(SalaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Salary VALUES (?, ?, ?, ?)");
        pstm.setString(1, dto.getSal_id());
        pstm.setString(2, dto.getAmount());
        pstm.setString(3, dto.getPayment_date());
        pstm.setString(4, dto.getEmNIC());

        return pstm.executeUpdate() > 0;
    }

    public String genSalId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT sal_id FROM Salary ORDER BY sal_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitRentId(resultSet.getString(1));
        }
        return splitRentId(null);
    }

    private String splitRentId(String currentRentId) {
        if(currentRentId != null) {

            String[] split = currentRentId.split("S00");
            System.out.println(split[0] + ", ");
            System.out.println(split[1]);
            int id = Integer.parseInt(split[1]); //01
            id++;
            if (id < 10) {
                return "S000" + id;
            } else {
                return "S00" + id;
            }
        } else {
            return "S0001";
        }
    }

    public String getsalary(String NIC) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement psmt =  connection.prepareStatement("SELECT * FROM Salary WHERE EmNIC = ?");
        psmt.setString(1, NIC);

        ResultSet resultSet = psmt.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString(2);
        }

        return null;
     }
}

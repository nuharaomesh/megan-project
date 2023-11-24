package lk.ijse.model;

import javafx.scene.control.Alert;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentModel {

    private TenantModel tenantModel = new TenantModel();
    private PaymentModel paymentModel = new PaymentModel();
    private AgreementModel agreementModel = new AgreementModel();
    private BailiffModel bailiffModel = new BailiffModel();
    private AgreementAndBailiffModel aAndBailiffModel = new AgreementAndBailiffModel();

    public boolean saveRent(RentDto rentDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Rent VALUES (?, ?, ?, ?, ?, ?, ?)");

        pstm.setString(1, rentDto.getRent_id());
        pstm.setString(2, rentDto.getDate());
        pstm.setDouble(3, rentDto.getAmount());
        pstm.setString(4, rentDto.getEmNIC());
        pstm.setString(5, rentDto.getPay_id());
        pstm.setString(6, rentDto.getTenant_id());
        pstm.setString(7, rentDto.getProp_id());

        return pstm.executeUpdate() > 0;
    }

    public boolean  registerRent(TenantDto tntDto, PaymentDto payDto, RentDto rentDto, AgreementDto agreementDto, BailiffDto bailDto, AgreementBailiffDto agAndBailDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        connection.setAutoCommit(false);
        try {
            if (tenantModel.saveTenant(tntDto)) {
                if (paymentModel.savePayment(payDto)) {
                    if (saveRent(rentDto)) {
                        if (agreementModel.saveAgreement(agreementDto)) {
                            if (bailiffModel.saveBailiff(bailDto)) {
                                if (aAndBailiffModel.saveBailNAgreement(agAndBailDto)) {
                                    connection.commit();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    public String genRenID() throws SQLException {
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
            String[] split = currentOrderId.split("R00");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "R000" + id;
        } else {
            return "R0001";
        }
    }
}

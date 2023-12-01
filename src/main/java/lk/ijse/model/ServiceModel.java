package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.ServiceDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceModel {
    public boolean saveService(ServiceDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Service VALUES(?, ?, ?, ?, ?, ?)");

        System.out.println(dto.getService_startDate());
        pstm.setString(1, dto.getProp_id());
        pstm.setString(2, dto.getNIC());
        pstm.setString(3, dto.getService_startDate());
        pstm.setString(4, dto.getService_endDate());
        pstm.setString(5, dto.getService_desc());
        pstm.setString(6, dto.getService_type());

        return pstm.executeUpdate() > 0;
    }
}

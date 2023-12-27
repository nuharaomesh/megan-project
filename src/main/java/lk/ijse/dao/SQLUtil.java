package lk.ijse.dao;

import lk.ijse.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {

    public static <T>T setQue(String sql, Object... values) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < values.length; i++) {
            pstm.setObject((i+1), values[i]);
        }

        if (sql.startsWith("SELECT")) {
            return (T) pstm.executeQuery();
        } else {
            return (T)(Boolean)(pstm.executeUpdate() > 0);
        }
    }
}

package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public boolean save(Salary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.setQue("INSERT INTO Salary VALUES (?, ?, ?, ?)", entity.getSal_id(), entity.getAmount(), entity.getPayment_date(), entity.getEmNIC());
    }

    @Override
    public boolean update(Salary dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Salary search(String email) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genId() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLUtil.setQue("SELECT sal_id FROM Salary ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {

            String id = rst.getString("sal_id");
            int agreementId = Integer.parseInt(id.replace("S00-", "")) + 1;
            return String.format("S00-%03d", agreementId);
        } else {
            return "S00-001";
        }
    }

    @Override
    public String getSalary(String email) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.setQue("SELECT * FROM Salary WHERE EmNIC = ?", email);

        String sal = "";
        if(rst.next()) sal = rst.getString(2);
        return sal;
    }
}

package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Salary;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.EMPLOYEE);
    private SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.SALARY);

    @Override
    public String genSalId() {
        return null;
    }

    @Override
    public boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        if (!employeeDAO.save(new Employee(empDto.getEmail(), empDto.getNIC(), empDto.getFirst_name(), empDto.getLast_name(), empDto.getAddress(), empDto.getPosition(), empDto.getStart_date(), empDto.getGender(), empDto.getDob(), empDto.getTel(), empDto.getEmp_detail()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!salaryDAO.save(new Salary(salDto.getSal_id(), salDto.getAmount(), salDto.getPayment_date(), salDto.getEmNIC()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public EmployeeDto searchEmp(String email) throws SQLException, ClassNotFoundException {
        return (EmployeeDto) (Object) employeeDAO.search(email);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) {
        return false;
    }

    @Override
    public String getEmployeeCount() {
        return null;
    }

    @Override
    public boolean deleteEmployee(String text) {
        return false;
    }

    @Override
    public Object getEmployeeId(String email) {
        return null;
    }

    @Override
    public String getSalary(Object employeeId) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<EmployeeDto> getPM() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getEmCount() throws SQLException, ClassNotFoundException {
        return null;
    }
}

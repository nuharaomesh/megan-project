package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Salary;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.EMPLOYEE);
    private SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.SALARY);

    @Override
    public String genSalId() throws SQLException, ClassNotFoundException {
        return salaryDAO.genId();
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

        Employee entity = employeeDAO.search(email);
        return new EmployeeDto(entity.getEmail(), entity.getNIC(), entity.getFirst_name(), entity.getLast_name(), entity.getAddress(), entity.getPosition(), entity.getStart_date(), entity.getGender(), entity.getDob(), entity.getTel(), entity.getEmp_detail());
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getEmail(), dto.getNIC(), dto.getFirst_name(), dto.getLast_name(), dto.getAddress(), dto.getPosition(), dto.getStart_date(), dto.getGender(), dto.getDob(), dto.getTel(), dto.getEmp_detail()));
    }

    @Override
    public String getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmpCount();
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public String getSalary(String email) throws SQLException, ClassNotFoundException {
        return salaryDAO.getSalary(email);
    }

    @Override
    public HashSet<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException {

        HashSet<Employee> list = employeeDAO.getAll();
        HashSet<EmployeeDto> dtoList = new HashSet<>();

        for (Employee ent : list) {
            dtoList.add(
                    new EmployeeDto(
                            ent.getEmail(),
                            ent.getNIC(),
                            ent.getFirst_name(),
                            ent.getLast_name(),
                            ent.getAddress(),
                            ent.getPosition(),
                            ent.getStart_date(),
                            ent.getGender(),
                            ent.getDob(),
                            ent.getTel(),
                            ent.getEmp_detail()
                    )
            );
        }
        return dtoList;
    }
}

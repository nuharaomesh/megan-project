package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;

import java.sql.SQLException;
import java.util.HashSet;

public interface EmployeeBO extends SuperBO {

    String genSalId() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto) throws SQLException, ClassNotFoundException;
    EmployeeDto searchEmp(String empEmail) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String text) throws SQLException, ClassNotFoundException;
    String getSalary(String employeeId) throws SQLException, ClassNotFoundException;
    HashSet<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException;
}

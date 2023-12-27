package lk.ijse.bo.custom;

import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO {

    String genSalId() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto) throws SQLException, ClassNotFoundException;
    EmployeeDto searchEmp(String empEmail) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String text) throws SQLException, ClassNotFoundException;
    Object getEmployeeId(String email) throws SQLException, ClassNotFoundException;
    String getSalary(Object employeeId) throws SQLException, ClassNotFoundException;
    List<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException;
}

package lk.ijse.bo.custom;

import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;

import java.util.List;

public interface EmployeeBO {

    String genSalId();
    boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto);
    EmployeeDto searchEmp(String empEmail);
    boolean updateEmployee(EmployeeDto dto);
    String getEmployeeCount();
    boolean deleteEmployee(String text);
    Object getEmployeeId(String email);
    String getSalary(Object employeeId);
    List<EmployeeDto> getAllEmployee();
}

package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.SalaryDto;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    @Override
    public String genSalId() {
        return null;
    }

    @Override
    public boolean saveEmployee(EmployeeDto empDto, SalaryDto salDto) {
        return false;
    }

    @Override
    public EmployeeDto searchEmp(String empEmail) {
        return null;
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
    public List<EmployeeDto> getAllEmployee() {
        return null;
    }
}

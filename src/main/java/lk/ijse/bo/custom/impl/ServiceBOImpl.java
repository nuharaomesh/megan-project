package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ServiceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.ServiceDAO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.ServiceDto;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Service;

import java.sql.SQLException;
import java.util.HashSet;

public class ServiceBOImpl implements ServiceBO {

    private ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.SERVICE);
    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean saveService(ServiceDto dto) throws SQLException, ClassNotFoundException {
        return serviceDAO.save(new Service(dto.getProp_id(), dto.getNIC(), dto.getService_startDate(), dto.getService_endDate(), dto.getService_desc(), dto.getService_type()));
    }

    @Override
    public HashSet<EmployeeDto> getPrpMang() throws SQLException, ClassNotFoundException {

        HashSet<Employee> list = employeeDAO.getPM();
        HashSet<EmployeeDto> dtoList = new HashSet<>();

        for (Employee ent : list) {
            dtoList.add(
                    new EmployeeDto(
                            ent.getNIC()
                    )
            );
        }
        return dtoList;
    }
}

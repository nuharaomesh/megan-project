package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterRentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.*;
import lk.ijse.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

public class RegisterRentBOImpl implements RegisterRentBO {

    private TenantDAO tenantDAO = (TenantDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.TENANT);
    private PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PAYMENT);
    private RentDAO rentDAO = (RentDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.RENT);
    private AgreementDAO agreementDAO = (AgreementDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.AGREEMENT);
    private BailiffDAO bailiffDAO = (BailiffDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.BAILIFF);
    private AgreementAndBailiffDAO agreeAndBlf = (AgreementAndBailiffDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.AGREEMENT_BAILIFF);
    private PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY);
    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public HashSet<EmployeeDto> getAllEmpl() throws SQLException, ClassNotFoundException {

        HashSet<Employee> list= employeeDAO.getAll();
        HashSet<EmployeeDto> dtoList = null;

        for (Employee ent : list) {
            dtoList.add(
                    new EmployeeDto(

                    )
            );
        }
        return dtoList;
    }

    @Override
    public String genRenID() throws SQLException, ClassNotFoundException {
        return rentDAO.genId();
    }

    @Override
    public String genPayID() throws SQLException, ClassNotFoundException {
        return paymentDAO.genId();
    }

    @Override
    public String genAgrID() throws SQLException, ClassNotFoundException {
        return agreementDAO.genId();
    }

    @Override
    public boolean registerRent(TenantDto tntDto, PaymentDto payDto, RentDto rentDto, AgreementDto agreementDto, BailiffDto bailDto, AgreementBailiffDto agAndBailDto) throws SQLException, ClassNotFoundException{

        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        if (!tenantDAO.save(new Tenant(tntDto.getTenant_id(), tntDto.getFirst_name(), tntDto.getLast_name(), tntDto.getEmail(), tntDto.getTel_no()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!paymentDAO.save(new Payment(payDto.getPay_id(), payDto.getAmount(), payDto.getPayment_date()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!rentDAO.save(new Rent(rentDto.getRent_id(), rentDto.getDate(), rentDto.getAmount(), rentDto.getEmNIC(), rentDto.getPay_id(), rentDto.getTenant_id(), rentDto.getProp_id()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!agreementDAO.save(new Agreement(agreementDto.getAgree_id(), agreementDto.getLease_startDate(), agreementDto.getLease_endDate(), agreementDto.getRent_id()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!bailiffDAO.save(new Bailiff(bailDto.getBail_id(), bailDto.getFirst_name(), bailDto.getLast_name(), bailDto.getOffice_address(), bailDto.getEmail(), bailDto.getTel_no()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!agreeAndBlf.save(new AgreementAndBailiff(agAndBailDto.getAgree_id(), agAndBailDto.getBail_id()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        if (!propertyDAO.changeSts((rentDto.getProp_id()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }
}

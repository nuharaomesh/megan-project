package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterRentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.*;
import lk.ijse.dao.custom.impl.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.*;
import lk.ijse.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RegisterRentBOImpl implements RegisterRentBO {

    private TenantDAO tenantDAO = (TenantDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.TENANT);
    private PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PAYMENT);
    private RentDAO rentDAO = (RentDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.RENT);
    private AgreementDAO agreementDAO = (AgreementDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.AGREEMENT);
    private BailiffDAO bailiffDAO = (BailiffDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.BAILIFF);
    private AgreementAndBailiffDAO agreeAndBlf = (AgreementAndBailiffDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.AGREEMENT);
    private PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.PROPERTY);

    @Override
    public List<EmployeeDto> getAllEmpl() {
        return null;
    }

    @Override
    public String genRenID() {
        return null;
    }

    @Override
    public String genPayID() {
        return null;
    }

    @Override
    public String genAgrID() {
        return null;
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

        if (!propertyDAO.update(new Property(rentDto.getProp_id()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }
}

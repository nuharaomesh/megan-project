package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.*;

import java.sql.SQLException;
import java.util.List;

public interface RegisterRentBO extends SuperBO {

    List<EmployeeDto> getAllEmpl() throws SQLException, ClassNotFoundException;
    String genRenID() throws SQLException, ClassNotFoundException;
    String genPayID() throws SQLException, ClassNotFoundException;
    String genAgrID() throws SQLException, ClassNotFoundException;
    boolean registerRent(TenantDto tntDto, PaymentDto payDto, RentDto rentDto, AgreementDto agreementDto, BailiffDto bailDto, AgreementBailiffDto agAndBailDto) throws SQLException, ClassNotFoundException;
}

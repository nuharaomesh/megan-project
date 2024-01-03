package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AgreementDto;
import lk.ijse.dto.TenantDto;
import lk.ijse.dto.TenantPrpDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TenantBO extends SuperBO {

    ArrayList<TenantDto> getAllTenant() throws SQLException, ClassNotFoundException;
    TenantPrpDto searchTnt(String tenantId) throws SQLException, ClassNotFoundException;
    boolean deleteTenant(String text) throws SQLException, ClassNotFoundException;
    TenantDto searchTenant(String tenantID) throws SQLException, ClassNotFoundException;
    boolean updateTnt(TenantDto dto) throws SQLException, ClassNotFoundException;
    AgreementDto getLeaseDate(String tenantId);
    String getTntCount() throws SQLException, ClassNotFoundException;
}

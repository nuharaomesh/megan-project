package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.TenantDto;

import java.sql.SQLException;
import java.util.HashSet;

public interface TenantBO extends SuperBO {

    HashSet<TenantDto> getAllTenant() throws SQLException, ClassNotFoundException;
    CustomDto getTntDet(String tenantId) throws SQLException, ClassNotFoundException;
    boolean deleteTenant(String text) throws SQLException, ClassNotFoundException;
    TenantDto searchTenant(String tenantID) throws SQLException, ClassNotFoundException;
    boolean updateTnt(TenantDto dto) throws SQLException, ClassNotFoundException;
    CustomDto getLeaseDate(String tenantId) throws SQLException, ClassNotFoundException;
}

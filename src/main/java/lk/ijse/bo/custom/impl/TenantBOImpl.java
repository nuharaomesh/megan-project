package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TenantBO;
import lk.ijse.dto.AgreementDto;
import lk.ijse.dto.TenantDto;
import lk.ijse.dto.TenantPrpDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenantBOImpl implements TenantBO {

    @Override
    public ArrayList<TenantDto> getAllTenant() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public TenantPrpDto searchTnt(String tenantId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteTenant(String text) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TenantDto searchTenant(String tenantID) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateTnt(TenantDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public AgreementDto getLeaseDate(String tenantId) {
        return null;
    }

    @Override
    public String getTntCount() throws SQLException, ClassNotFoundException {
        return null;
    }
}

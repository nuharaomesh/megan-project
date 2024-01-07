package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TenantBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dao.custom.TenantDAO;
import lk.ijse.dto.AgreementDto;
import lk.ijse.dto.CustomDto;
import lk.ijse.dto.TenantDto;
import lk.ijse.entity.Custom;
import lk.ijse.entity.Tenant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class TenantBOImpl implements TenantBO {

    private TenantDAO tenantDAO = (TenantDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.TENANT);
    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getTypes(DAOFactory.DAOTypes.QUERY);

    @Override
    public HashSet<TenantDto> getAllTenant() throws SQLException, ClassNotFoundException {

        HashSet<Tenant> list = tenantDAO.getAll();
        HashSet<TenantDto> dtoSet = new HashSet<>();

        for (Tenant tenant : list) {
            dtoSet.add(
                    new TenantDto(
                            tenant.getTenant_id(),
                            tenant.getFirst_name(),
                            tenant.getEmail(),
                            tenant.getTel_no()
                    )
            );
        }
        return dtoSet;
    }

    @Override
    public CustomDto getTntDet(String tenantId) throws SQLException, ClassNotFoundException { //join

        Custom entity = queryDAO.getTntDet();
        return new CustomDto(entity.getTenantFirstName(), entity.getTenantLastName(), entity.getTenantEmail(), entity.getTenantTel(), entity.getRentAmount(), entity.getPrpType());
    }

    @Override
    public boolean deleteTenant(String email) throws SQLException, ClassNotFoundException {
        return tenantDAO.delete(email);
    }

    @Override
    public TenantDto searchTenant(String id) throws SQLException, ClassNotFoundException {

        Tenant ent = tenantDAO.search(id);
        return new TenantDto(ent.getTenant_id(), ent.getFirst_name(), ent.getLast_name(), ent.getEmail(), ent.getTel_no());
    }

    @Override
    public boolean updateTnt(TenantDto dto) throws SQLException, ClassNotFoundException {
        return tenantDAO.update(new Tenant(dto.getTenant_id(), dto.getFirst_name(), dto.getLast_name(), dto.getEmail(), dto.getTel_no()));
    }

    @Override
    public CustomDto getLeaseDate(String id) throws SQLException, ClassNotFoundException {//join
        Custom custom = queryDAO.getTntLeaseDate(id);
        return new CustomDto(custom.getLease_StartDate(), custom.getLease_endDate());
    }
}

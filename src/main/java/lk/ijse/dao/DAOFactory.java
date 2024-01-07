package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        AGREEMENT_BAILIFF,AGREEMENT,BAILIFF,EMPLOYEE,PAYMENT,PROPERTY,PROPERTY_OWNER,QUERY,RENT,SALARY,SERVICE,TENANT,USER
    }

    public SuperDAO getTypes(DAOTypes daoTypes) {

        switch (daoTypes) {
            case AGREEMENT_BAILIFF:
                return new AgreementAndBailiffDAOImpl();
            case AGREEMENT:
                return new AgreementDAOImpl();
            case BAILIFF:
                return new BailiffDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case PROPERTY:
                return new PropertyDAOImpl();
            case PROPERTY_OWNER:
                return new PropertyOwnerDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case RENT:
                return new RentDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case SERVICE:
                return new ServiceDAOImpl();
            case TENANT:
                return new TenantDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}

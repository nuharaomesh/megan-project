package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getDaoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        EMPLOYEE,LOGIN,PAYMENT,PROPERTY,PROPERTY_OWNER,REGISTER_RENT,SERVICE,SIGN_IN,TENANT
    }

    public SuperBO getTypes(BOTypes boTypes) {

        switch (boTypes) {
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case PROPERTY:
                return new PropertyBOImpl();
            case PROPERTY_OWNER:
                return new PropertyOwnerBOImpl();
            case REGISTER_RENT:
                return new RegisterRentBOImpl();
            case SERVICE:
                return new ServiceBOImpl();
            case SIGN_IN:
                return new SignInBOImpl();
            case TENANT:
                return new TenantBOImpl();
            default:
                return null;
        }
    }
}

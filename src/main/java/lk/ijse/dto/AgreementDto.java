package lk.ijse.dto;

public class AgreementDto {

    private String agree_id;
    private String lease_startDate;
    private String lease_endDate;
    private String rent_id;

    public AgreementDto() {
    }

    public AgreementDto(String agree_id, String lease_startDate, String lease_endDate, String rent_id) {
        this.agree_id = agree_id;
        this.lease_startDate = lease_startDate;
        this.lease_endDate = lease_endDate;
        this.rent_id = rent_id;
    }

    public String getAgree_id() {
        return agree_id;
    }

    public void setAgree_id(String agree_id) {
        this.agree_id = agree_id;
    }

    public String getLease_startDate() {
        return lease_startDate;
    }

    public void setLease_startDate(String lease_startDate) {
        this.lease_startDate = lease_startDate;
    }

    public String getLease_endDate() {
        return lease_endDate;
    }

    public void setLease_endDate(String lease_endDate) {
        this.lease_endDate = lease_endDate;
    }

    public String getRent_id() {
        return rent_id;
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    @Override
    public String toString() {
        return "AgreementDto{" +
                "agree_id='" + agree_id + '\'' +
                ", lease_startDate='" + lease_startDate + '\'' +
                ", lease_endDate='" + lease_endDate + '\'' +
                ", rent_id='" + rent_id + '\'' +
                '}';
    }
}

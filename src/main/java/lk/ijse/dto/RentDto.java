package lk.ijse.dto;

import com.sun.jdi.event.StepEvent;

import java.lang.ref.SoftReference;

public class RentDto {

    private String rent_id;
    private String date;
    private double amount;
    private String EmNIC;
    private String pay_id;
    private String tenant_id;

    public RentDto() {
    }

    public RentDto(String rent_id, String date, double amount, String emNIC, String pay_id, String tenant_id) {
        this.rent_id = rent_id;
        this.date = date;
        this.amount = amount;
        EmNIC = emNIC;
        this.pay_id = pay_id;
        this.tenant_id = tenant_id;
    }

    public String getRent_id() {
        return rent_id;
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEmNIC() {
        return EmNIC;
    }

    public void setEmNIC(String emNIC) {
        EmNIC = emNIC;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "RentDto{" +
                "rent_id='" + rent_id + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", EmNIC='" + EmNIC + '\'' +
                ", pay_id='" + pay_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }
}

package lk.ijse.dto;

public class SalaryDto {
    private String sal_id;
    private double amount;
    private String payment_date;
    private String EmNIC;

    public SalaryDto() {
    }

    public SalaryDto(String sal_id, double amount, String payment_date, String emNIC) {
        this.sal_id = sal_id;
        this.amount = amount;
        this.payment_date = payment_date;
        EmNIC = emNIC;
    }

    public String getSal_id() {
        return sal_id;
    }

    public void setSal_id(String sal_id) {
        this.sal_id = sal_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getEmNIC() {
        return EmNIC;
    }

    public void setEmNIC(String emNIC) {
        EmNIC = emNIC;
    }

    @Override
    public String toString() {
        return "SalaryDto{" +
                "sal_id='" + sal_id + '\'' +
                ", amount=" + amount +
                ", payment_date='" + payment_date + '\'' +
                ", EmNIC='" + EmNIC + '\'' +
                '}';
    }
}

package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomDto {

    private String poFirstName;
    private String poEmail;
    private String poTel;
    private String prpName;
    private String tenantFirstName;
    private String tenantLastName;
    private String tenantEmail;
    private String tenantTel;
    private String rentAmount;
    private String prpType;
    private String tenantId;
    private String lease_StartDate;
    private String lease_endDate;

    public CustomDto(String poFirstName, String poEmail, String poTel, String prpName) {
        this.poFirstName = poFirstName;
        this.poEmail = poEmail;
        this.poTel = poTel;
        this.prpName = prpName;
    }

    public CustomDto(String tenantFirstName, String tenantLastName, String tenantEmail, String tenantTel, String rentAmount, String prpType) {
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.tenantEmail = tenantEmail;
        this.tenantTel = tenantTel;
        this.rentAmount = rentAmount;
        this.prpType = prpType;
    }

    public CustomDto(String lease_StartDate, String lease_endDate) {
        this.lease_StartDate = lease_StartDate;
        this.lease_endDate = lease_endDate;
    }
}

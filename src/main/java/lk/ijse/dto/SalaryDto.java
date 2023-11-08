package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SalaryDto {

    private String sal_id;
    private double amount;
    private String payment_date;
    private String EmNIC;
}

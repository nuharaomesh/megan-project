package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Salary {

    private String sal_id;
    private String amount;
    private String payment_date;
    private String EmNIC;
}

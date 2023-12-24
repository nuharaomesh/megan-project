package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Rent {

    private String rent_id;
    private String date;
    private double amount;
    private String EmNIC;
    private String pay_id;
    private String tenant_id;
    private String prop_id;
}

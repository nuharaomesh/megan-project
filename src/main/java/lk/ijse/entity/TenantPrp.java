package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TenantPrp {

    private String first_name;
    private String last_name;
    private String email;
    private String tel_no;
    private double rent_amount;
    private String property_type;
}

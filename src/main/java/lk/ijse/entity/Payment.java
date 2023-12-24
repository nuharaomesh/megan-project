package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Payment {

    private String pay_id;
    private String amount;
    private String payment_date;

}

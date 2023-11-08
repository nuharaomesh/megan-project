package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PaymentDto {

    private String pay_id;
    private String amount;
    private String payment_date;

}

package lk.ijse.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyTm {

    private String property_name;
    private String address;
    private double rent_amount;
}

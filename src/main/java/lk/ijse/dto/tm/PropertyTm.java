package lk.ijse.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyTm {

    private String property_id;
    private String property_name;
    private String address;
    private String property_type;
    private String rent_amount;

    public PropertyTm(String property_id, String property_name, String address, String  rent_amount) {
        this.property_id = property_id;
        this.property_name = property_name;
        this.address = address;
        this.rent_amount = rent_amount;
    }
}

package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyDto {

    private String prop_id;
    private String name;
    private String address;
    private String property_type;
    private String rent_amount;
    private String prpOwner_id;

    public PropertyDto(String prop_id, String name, String address, String rent_amount) {
        this.prop_id = prop_id;
        this.name = name;
        this.address = address;
        this.rent_amount = rent_amount;
    }
}

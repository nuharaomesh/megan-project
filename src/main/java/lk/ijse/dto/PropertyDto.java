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
    private double rent_amount;
    private String prpOwner_id;

    public PropertyDto(String name, String address, double rent_amount) {
        this.name = name;
        this.address = address;
        this.rent_amount = rent_amount;
    }
}

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
    private String image;
    private String image2;
    private String image3;
    private String property_type;
    private double rent_amount;
    private String prpOwner_id;
    private String rent_id;
}

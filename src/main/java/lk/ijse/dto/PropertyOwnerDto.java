package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyOwnerDto {

    private String email;
    private String prpOwner_id;
    private String first_name;
    private String last_name;
    private String tel_no;

    public PropertyOwnerDto(String last_name) {
        this.last_name = last_name;
    }
}

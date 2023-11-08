package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyOwnerDto {

    private String prpOwner_id;
    private String first_name;
    private String last_name;
    private String email;
    private String tel_no;
}

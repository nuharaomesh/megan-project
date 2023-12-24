package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PropertyOwner {

    private String email;
    private String prpOwner_id;
    private String first_name;
    private String last_name;
    private String tel_no;

    public PropertyOwner(String last_name) {
        this.last_name = last_name;
    }
}

package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Bailiff {

    private String bail_id;
    private String first_name;
    private String last_name;
    private String office_address;
    private String email;
    private String tel_no;
}

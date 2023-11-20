package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TenantDto {

    private String tenant_id;
    private String first_name;
    private String last_name;
    private String email;
    private String tel_no;

    public TenantDto(String first_name, String last_name, String email, String tel_no) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.tel_no = tel_no;
    }
}

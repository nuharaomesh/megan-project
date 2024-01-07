package lk.ijse.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TenantTm {

    private String tenant_id;
    private String first_name;
    private String email;
    private String tel_no;
}
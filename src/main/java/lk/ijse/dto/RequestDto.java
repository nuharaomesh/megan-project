package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class RequestDto {

    private String req_id;
    private String request;
    private String tenant_id;
}

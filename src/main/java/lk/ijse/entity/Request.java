package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Request {

    private String req_id;
    private String request;
    private String tenant_id;
}

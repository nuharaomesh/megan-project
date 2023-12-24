package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Service {

    private String prop_id;
    private String NIC;
    private String service_startDate;
    private String service_endDate;
    private String service_desc;
    private String service_type;
}

package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ServiceDto {

    private String prop_id;
    private String NIC;
    private String service_startDate;
    private String service_endDate;
    private String service_desc;
    private String service_type;
}

package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AgreementDto {

    private String agree_id;
    private String lease_startDate;
    private String lease_endDate;
    private String rent_id;
}

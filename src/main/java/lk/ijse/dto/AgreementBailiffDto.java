package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AgreementBailiffDto {

    private String agree_id;
    private String bail_id;
    private String Assignment_reason;
}

package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeDto {

    private String NIC;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String position;
}

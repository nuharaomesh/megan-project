package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeDto {

    private String email;
    private String NIC;
    private String first_name;
    private String last_name;
    private String address;
    private String position;
    private String start_date;
    private String gender;
    private String dob;
    private String tel;
    private String emp_detail;

    public EmployeeDto(String email, String NIC, String first_name, String last_name, String address, String position, String start_date, String gender, String dob, String tel) {
        this.email = email;
        this.NIC = NIC;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.position = position;
        this.start_date = start_date;
        this.gender = gender;
        this.dob = dob;
        this.tel = tel;
    }

    public EmployeeDto(String NIC) {
        this.NIC = NIC;
    }
}

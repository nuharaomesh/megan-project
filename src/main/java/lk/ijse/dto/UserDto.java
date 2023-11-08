package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserDto {

    private String user_id;
    private String username;
    private String password;
    private String tel_no;
}

package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserDto {

    private String username;
    private String user_id;
    private String password;
    private String first_name;
    private String last_name;
    private String position;

    public UserDto(String user_id, String password) {
        this.username = user_id;
        this.password = password;
    }
}

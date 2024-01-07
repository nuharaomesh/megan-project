package lk.ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {

    private String username;
    private String user_id;
    private String password;
    private String first_name;
    private String last_name;
    private String position;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

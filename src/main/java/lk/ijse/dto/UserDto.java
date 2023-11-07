package lk.ijse.dto;

public class UserDto {
    private String user_id;
    private String username;
    private String password;
    private String tel_no;

    public UserDto() {
    }
    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserDto(String user_id, String username, String password, String tel_no) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.tel_no = tel_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }
}

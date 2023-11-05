package lk.ijse.dto;

public class PropertyOwnerDto {

    private String prpOwner_id;
    private String first_name;
    private String last_name;
    private String email;
    private String tel_no;

    public PropertyOwnerDto() {
    }

    public PropertyOwnerDto(String prpOwner_id, String first_name, String last_name, String email, String tel_no) {
        this.prpOwner_id = prpOwner_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.tel_no = tel_no;
    }

    public String getPrpOwner_id() {
        return prpOwner_id;
    }

    public void setPrpOwner_id(String prpOwner_id) {
        this.prpOwner_id = prpOwner_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    @Override
    public String toString() {
        return "PropertyOwnerDto{" +
                "prpOwner_id='" + prpOwner_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }
}

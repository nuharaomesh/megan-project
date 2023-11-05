package lk.ijse.dto;

public class BailiffDto {

    private String bail_id;
    private String first_name;
    private String last_name;
    private String office_address;
    private String email;
    private String tel_no;

    public BailiffDto() {
    }

    public BailiffDto(String bail_id, String first_name, String last_name, String office_address, String email, String tel_no) {
        this.bail_id = bail_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.office_address = office_address;
        this.email = email;
        this.tel_no = tel_no;
    }

    public String getBail_id() {
        return bail_id;
    }

    public void setBail_id(String bail_id) {
        this.bail_id = bail_id;
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

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
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
        return "BailiffDto{" +
                "bail_id='" + bail_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", office_address='" + office_address + '\'' +
                ", email='" + email + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }
}

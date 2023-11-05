package lk.ijse.dto;

public class TenantDto {
    private String tenant_id;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String tel_no;

    public TenantDto() {
    }

    public TenantDto(String tenant_id, String first_name, String last_name, String address, String email, String tel_no) {
        this.tenant_id = tenant_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.tel_no = tel_no;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "TenantDto{" +
                "tenant_id='" + tenant_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }
}

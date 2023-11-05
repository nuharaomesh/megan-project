package lk.ijse.dto;

public class EmployeeDto {
    private String NIC;
    private String first_name;
    private String last_name;
    private String address;
    private String position;

    public EmployeeDto() {
    }
    public EmployeeDto(String NIC, String first_name, String last_name, String address, String position) {
        this.NIC = NIC;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.position = position;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "NIC='" + NIC + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

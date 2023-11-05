package lk.ijse.dto;

public class ServiceDto {

    private String prop_id;
    private String NIC;
    private String service_startDate;
    private String service_endDate;
    private String service_desc;
    private String service_type;

    public ServiceDto() {
    }

    public ServiceDto(String prop_id, String NIC, String service_startDate, String service_endDate, String service_desc, String service_type) {
        this.prop_id = prop_id;
        this.NIC = NIC;
        this.service_startDate = service_startDate;
        this.service_endDate = service_endDate;
        this.service_desc = service_desc;
        this.service_type = service_type;
    }

    public String getProp_id() {
        return prop_id;
    }

    public void setProp_id(String prop_id) {
        this.prop_id = prop_id;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getService_startDate() {
        return service_startDate;
    }

    public void setService_startDate(String service_startDate) {
        this.service_startDate = service_startDate;
    }

    public String getService_endDate() {
        return service_endDate;
    }

    public void setService_endDate(String service_endDate) {
        this.service_endDate = service_endDate;
    }

    public String getService_desc() {
        return service_desc;
    }

    public void setService_desc(String service_desc) {
        this.service_desc = service_desc;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    @Override
    public String toString() {
        return "ServiceDto{" +
                "prop_id='" + prop_id + '\'' +
                ", NIC='" + NIC + '\'' +
                ", service_startDate='" + service_startDate + '\'' +
                ", service_endDate='" + service_endDate + '\'' +
                ", service_desc='" + service_desc + '\'' +
                ", service_type='" + service_type + '\'' +
                '}';
    }
}

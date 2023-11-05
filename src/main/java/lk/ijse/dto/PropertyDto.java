package lk.ijse.dto;

public class PropertyDto {
    private String prop_id;
    private String name;
    private String address;
    private String image;
    private String image2;
    private String image3;
    private String property_type;
    private double rent_amount;
    private String prpOwner_id;
    private String rent_id;

    public PropertyDto() {
    }

    public PropertyDto(String prop_id, String name, String address, String image, String image2, String image3, String property_type, double rent_amount, String prpOwner_id, String rent_id) {
        this.prop_id = prop_id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.property_type = property_type;
        this.rent_amount = rent_amount;
        this.prpOwner_id = prpOwner_id;
        this.rent_id = rent_id;
    }

    public String getProp_id() {
        return prop_id;
    }

    public void setProp_id(String prop_id) {
        this.prop_id = prop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public double getRent_amount() {
        return rent_amount;
    }

    public void setRent_amount(double rent_amount) {
        this.rent_amount = rent_amount;
    }

    public String getPrpOwner_id() {
        return prpOwner_id;
    }

    public void setPrpOwner_id(String prpOwner_id) {
        this.prpOwner_id = prpOwner_id;
    }

    public String getRent_id() {
        return rent_id;
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    @Override
    public String toString() {
        return "PropertyDto{" +
                "prop_id='" + prop_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", property_type='" + property_type + '\'' +
                ", rent_amount=" + rent_amount +
                ", prpOwner_id='" + prpOwner_id + '\'' +
                ", rent_id='" + rent_id + '\'' +
                '}';
    }
}

package lk.ijse.dto;

public class AgreementBailiffDto {

    private String agree_id;
    private String bail_id;
    private String Assignment_reason;

    public AgreementBailiffDto() {
    }

    public AgreementBailiffDto(String agree_id, String bail_id, String assignment_reason) {
        this.agree_id = agree_id;
        this.bail_id = bail_id;
        Assignment_reason = assignment_reason;
    }

    public String getAgree_id() {
        return agree_id;
    }

    public void setAgree_id(String agree_id) {
        this.agree_id = agree_id;
    }

    public String getBail_id() {
        return bail_id;
    }

    public void setBail_id(String bail_id) {
        this.bail_id = bail_id;
    }

    public String getAssignment_reason() {
        return Assignment_reason;
    }

    public void setAssignment_reason(String assignment_reason) {
        Assignment_reason = assignment_reason;
    }

    @Override
    public String toString() {
        return "AgreementBailiffDto{" +
                "agree_id='" + agree_id + '\'' +
                ", bail_id='" + bail_id + '\'' +
                ", Assignment_reason='" + Assignment_reason + '\'' +
                '}';
    }
}

package lk.ijse.plugin;

import javafx.scene.control.Alert;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.PropertyDto;
import lk.ijse.dto.PropertyOwnerDto;

import java.util.regex.Pattern;

public class Validation {

    public boolean getValidation(String type, Object dto) {

        if (type.equals("Employee")) {
            EmployeeDto empDto = (EmployeeDto) dto;
            if (!Pattern.matches("[0-9]{10}", empDto.getNIC())) {
                new Alert(Alert.AlertType.ERROR, "Invalid NIC!!").show();
                return false;
            }

            if (!Pattern.matches("([A-Za-z])+\\w", empDto.getFirst_name())) {
                new Alert(Alert.AlertType.ERROR, "Invalid First name!!").show();
                return false;
            }

            if (!Pattern.matches("([A-Za-z])+\\w", empDto.getLast_name())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Last name!!").show();
                return false;
            }

            if (!Pattern.matches("([A-z]+.gmail[.]com)", empDto.getEmail())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Email!!").show();
                return false;
            }

            if (!Pattern.matches("([A-Za-z])+\\w", empDto.getAddress())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Address!!").show();
                return false;
            }

            if (!Pattern.matches("[A-z\\s]+\\w", empDto.getPosition())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Position!!").show();
                return false;
            }

            return true;
        } else if (type.equals("Property owner")) {

            PropertyOwnerDto prpOwn = (PropertyOwnerDto) dto;
            if (!Pattern.matches("[0-9]{10}", prpOwn.getPrpOwner_id())) {
                new Alert(Alert.AlertType.ERROR, "Invalid NIC").show();
                return false;
            }
            if (!Pattern.matches("([A-Za-z])+\\w", prpOwn.getFirst_name())) {
                new Alert(Alert.AlertType.ERROR, "Invalid first name!!").show();
                return false;
            }
            if (!Pattern.matches("([A-Za-z])+\\w", prpOwn.getLast_name())) {
                new Alert(Alert.AlertType.ERROR, "Invalid last name!!").show();
                return false;
            }
            if (!Pattern.matches("([A-z]+.gmail[.]com)", prpOwn.getEmail())) {
                new Alert(Alert.AlertType.ERROR, "Invalid email!!").show();
                return false;
            }

            if (!Pattern.matches("[0-9]{10}", prpOwn.getTel_no())) {
                new Alert(Alert.AlertType.ERROR, "Invalid tel!!").show();
            }

            return true;
        } else if (type.equals("Property")) {

            PropertyDto prpDto = (PropertyDto) dto;
            if (!Pattern.matches("((P)[0-9]{3,})", prpDto.getProp_id())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Property ID!!").show();
                return false;
            }
            if (!Pattern.matches("([A-Za-z\\s])+\\w", prpDto.getName())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Property name!!").show();
                return false;
            }
            if (!Pattern.matches("([A-Za-z\\s])+", prpDto.getAddress())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Address!!").show();
                return false;
            }
            if (!Pattern.matches("([A-Za-z\\s])+", prpDto.getProperty_type())) {
                new Alert(Alert.AlertType.ERROR, "Invalid Property type!!").show();
                return false;
            }
            if (!Pattern.matches("([0-9]){2,}", prpDto.getRent_amount())) {
                new Alert(Alert.AlertType.ERROR, "Invalid rent amount!!").show();
                return false;
            }

            return true;
        } else if (type.equals("Tenant")) {

        } else if (type.equals("Rent")) {

        } else {
            new Alert(Alert.AlertType.ERROR, "You given type is wrong!!" + type).show();
        }
        new Alert(Alert.AlertType.ERROR, "Not valid!!!").show();
        return false;
    }
}

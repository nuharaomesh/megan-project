package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;


public class ReportsFormController {

    @FXML
    void btnAgreementRepOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployeeRepOnAction(ActionEvent event) throws JRException, SQLException {

    }

    @FXML
    void btnPropertyOwnerRepOnAction(ActionEvent event) {

    }

    @FXML
    void btnPropertyRepOnAction(ActionEvent event) throws JRException, SQLException {

    }

    @FXML
    void btnServiceRepOnAction(ActionEvent event) {

    }

    @FXML
    void btnTenantRepOnAction(ActionEvent event) throws JRException, SQLException {

    }

    public void setReport(String report) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream(report);

        JasperDesign load = JRXmlLoader.load(resourceAsStream);

        JasperReport jasperReport = JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );

        JasperViewer.viewReport(jasperPrint, false);
    }
}

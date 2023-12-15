package lk.ijse;

import com.mysql.cj.exceptions.CJConnectionFeatureNotAvailableException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/main_form.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.getIcons().add(new javafx.scene.image.Image("/icons/acc.png"));
        stage.show();
    }
}

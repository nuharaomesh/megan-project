package lk.ijse;

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


        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"))));

        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();

        stage.show();
        //load scene graph to the application
//        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
//
//        create a new Scene
//        Scene scene = new Scene(rootNode);
//
//        set scene to the primary stage
//        stage.setScene(scene);
//
//        set a title and set center on screen
//        stage.setTitle("Main Form");
//        stage.centerOnScreen();
//
//        show scene to the crowd
//        stage.show();
    }
}

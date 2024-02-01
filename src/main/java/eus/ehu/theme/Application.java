package eus.ehu.theme;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {

    private String darkmode;
    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        // get controller
        AppController controller = fxmlLoader.getController();

        scene = new Scene(root);


        File style = new File("darktheme.css");
        darkmode = style.toURI().toURL().toExternalForm();

        controller.setMain(this);

        stage.setTitle("Choose your theme");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    public void applyTheme(String selectedTheme) {

        switch (selectedTheme){
            case "Dark Mode":
                System.out.println("Dark Mode");
                scene.getStylesheets().add(darkmode);
                break;
            case "Light Mode":
                System.out.println("Light Mode");
                scene.getStylesheets().clear();
                break;
            default:
                System.err.println("Error!");
                break;
        }
    }
}

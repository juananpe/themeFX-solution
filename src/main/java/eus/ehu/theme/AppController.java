package eus.ehu.theme;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AppController {

    @FXML
    private ToggleGroup themes;
    private Application main;
    private Properties prop = new Properties();

    @FXML
    void applyClick(ActionEvent event) {
        RadioButton selectedToggle = (RadioButton) themes.getSelectedToggle();
        main.applyTheme(selectedToggle.getText());

        prop.setProperty("theme", selectedToggle.getText());
        saveProperties();

    }

    private void saveProperties() {
        try (FileOutputStream output = new FileOutputStream("config.properties")) {
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void setTheme(){
        if (prop.getProperty("theme").equalsIgnoreCase("Dark Mode")){
            System.out.println("Dark Mode");
            themes.getToggles().get(0).setSelected(true);
            applyClick(null);

        } else {
            System.out.println("Light Mode");
            themes.getToggles().get(1).setSelected(true);
            applyClick(null);

        }
    }

    @FXML
    void initialize() {
        try (InputStream input = new
                FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void setMain(Application application) {
        this.main = application;
        setTheme();
    }
}

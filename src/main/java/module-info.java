module eus.ehu.theme {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eus.ehu.theme to javafx.fxml;
    exports eus.ehu.theme;
}

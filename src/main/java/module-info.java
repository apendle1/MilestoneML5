module org.example.milestone5ml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.milestone5ml to javafx.fxml;
    exports org.example.milestone5ml;
}
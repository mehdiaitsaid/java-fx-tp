module lst.gi.javafxtps {
    requires javafx.controls;
    requires javafx.fxml;


    opens lst.fsts.javafxtps to javafx.fxml;
    exports lst.fsts.javafxtps;
}
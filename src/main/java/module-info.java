module src.minenraeumerfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.minenraeumerfx to javafx.fxml;
    exports src.minenraeumerfx;
}
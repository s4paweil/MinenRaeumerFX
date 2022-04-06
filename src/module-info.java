module src.minenraeumerfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens minenraeumerfx to javafx.fxml;
    exports minenraeumerfx;
}
package minenraeumerfx;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

     

public class Knopf extends Button
 { Feld feld;
   Knopf(Feld feld)
    { this.feld=feld;
      this.setPrefSize(36,18);
      this.setOnAction(myHandler);
    }


     static EventHandler<ActionEvent> myHandler =
             new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent e) {
                     Feld feld=((Knopf) e.getSource()).feld;
                     feld.aufdecken();
                 }};

 }
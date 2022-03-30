package src.minenraeumerfx;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

     
// Die Klasse Knopf merkt sich, welches Feld der
// erzeugte Button repräsentiert.
public class Knopf extends Button
 { Feld feld;
   Knopf(Feld feld)
    { this.feld=feld;
      this.setPrefSize(36,18);
      this.setOnAction(myHandler);
    }

     // Wir verwenden einen Eventhandler für alle Buttons. Mit Hilfe von
     // e.getSource() können sie feststellen, welcher Button angeklickt wurde.
     static EventHandler<ActionEvent> myHandler =
             new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent e) {
                     Feld feld=((Knopf) e.getSource()).feld;
                     feld.aufdecken();
                 }};

 }
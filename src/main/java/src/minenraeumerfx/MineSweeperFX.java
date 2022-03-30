package src.minenraeumerfx;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MineSweeperFX extends Application{
  
   public void init() {   }
  
  public void start(Stage primaryStage) throws Exception 
    {
        // Zum Anordnen der Spielfelder im Fenster verwenden wir ein GridPane. Dieser Container ordnet die in ihm
        // eingetragenen Element in einem Gitter an. Jedes Element hat dabei gleich viel Platz.
        GridPane root = new GridPane();

        // Das Spiel wird erzeugt, d.h. die Datenstruktur zum Verwalten des Spielzustandes
        // Die visuellen Elemente, d.h. die Button-Elemente in der Spieldatenstruktur werden in den Szenengraph
        // eingebaut, d.h. in die Gridpane an der entsprechenden Stelle eingef?gt.
        Spiel spiel = new Spiel(20,10,root);
    
        Scene scene = new Scene(root);
        primaryStage.setTitle("MinenSweeperFX");
        primaryStage.setScene(scene);        
        primaryStage.show(); 
    }
  
  public static void main(String[] args){
     launch(args);
   }
  
}
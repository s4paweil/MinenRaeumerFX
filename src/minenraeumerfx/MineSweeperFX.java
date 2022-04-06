package minenraeumerfx;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MineSweeperFX extends Application{
  
   public void init() {   }
  
  public void start(Stage primaryStage) throws Exception 
    {

        GridPane root = new GridPane();

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
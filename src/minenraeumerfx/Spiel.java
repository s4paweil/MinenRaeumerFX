package minenraeumerfx;

import javafx.scene.layout.GridPane;


public class Spiel
{ int cols,rows;
  Feld felder[][];
  int aufgedeckteFelder;
  int anzahlBomben;

  Spiel(int cols, int rows, GridPane gridPane)
   { this.cols=cols; 
     this.rows=rows;

     felder=new Feld[cols][rows];
     for(int i=0; i<cols;i++)
      for(int j=0; j<rows; j++) {
          felder[i][j] = new Feld(this, i, j);
          gridPane.add(felder[i][j].knopf, i, j);
      }

     for(int i=0; i<cols;i++)
      for(int j=0; j<rows; j++) felder[i][j].berechneBomben(); 

      
   }   
}                                 
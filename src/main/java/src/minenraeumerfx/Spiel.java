package src.minenraeumerfx;

import javafx.scene.layout.GridPane;

// Die Klasse Spiel dient zum Verwalten des Spielzustandes.
public class Spiel
{ int cols,rows;    // Dimensionen des Spielfeldes
  Feld felder[][];
  int aufgedeckteFelder; // Anzahl der Felder, die bisher aufgedeckt wurden
  int anzahlBomben; // Anzahl aller Bomben im Spiel

  Spiel(int cols, int rows, GridPane gridPane)
   { this.cols=cols; 
     this.rows=rows;
     // alle Felder des Spielfeldes werden erzeugt und
     // ihre visuellen Elemente in der GUI hinzugef?gt
     felder=new Feld[cols][rows];
     for(int i=0; i<cols;i++)
      for(int j=0; j<rows; j++) {
          felder[i][j] = new Feld(this, i, j);
          gridPane.add(felder[i][j].knopf, i, j);
      }
     // Manche der erzeugten Felder enthalten Bomben. Nachdem alle
     // Felder erzeugt wurden, k?nnen wir jetzt noch mal alle
     // Felder besuchen und f?r jedes Feld bestimmen, wieviele
     // benachbarte Felder eine Bombe enthalten.
     for(int i=0; i<cols;i++)
      for(int j=0; j<rows; j++) felder[i][j].berechneBomben(); 

    // nur zum Debuggen  
    // for(int i=0; i<cols;i++)
    //  for(int j=0; j<rows; j++)  
    //   { Feld f=felder[i][j];
    //     if (f.istBombe) f.knopf.setText("B"); else f.knopf.setText(""+f.benachbarteBomben); 
    //   } 
      
   }   
}                                 
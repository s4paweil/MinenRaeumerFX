package src.minenraeumerfx;

public class Feld
{ int col, row; // das Feld merkt sich seine Position im Spielfeld
  Spiel spiel;
  boolean istBombe; 
  boolean istAufgedeckt=false;
  int benachbarteBomben; // Anzahl der benachbarten Felder, die eine Bombe sind
  Knopf knopf; // Button-Objekt, das in der GUI das Feld darstellt.
  
  Feld(Spiel spiel, int col, int row)
   { this.col=col; 
     this.row=row;
     this.spiel=spiel;
     istBombe=(Math.random()<0.05); // bestimme zufällig, ob das Feld eine Bombe ist
     if (istBombe) spiel.anzahlBomben++;
     knopf = new Knopf(this); // erzeuge einen Button, dieser merkt sich, welches
                                  // Feld (this) er repräsentiert.
     //zum Debuggen:
     //if (istBombe) knopf.setText("B"); else knopf.setText("...");
     //if (istBombe) knopf.setText("B"); else knopf.setText(""+benachbarteBomben);

   }

  // Diese Methode wird vom Eventhandler aufgerufen, d.h. wenn ein Knopf
  // angeklickt wird. Sie prüft, ob das angeklickte Feld ein Bombe ist.
  // Falls nicht, wird das Feld aufgedeckt. Falls zusätzlich keines der 
  // benachbarten Felder eine Bombe enthält, werden auch die benachbarten
  // Felder mit Hilfe der Funktion propagiere() aufgedeckt.
  
  void aufdecken()
   { if (istBombe) 
      { knopf.setText("B"); 
        knopf.setStyle("-fx-background-color: #ff0000");
        System.out.println("Leider verloren");
      }
      else propagiere();
      if (spiel.aufgedeckteFelder+spiel.anzahlBomben==spiel.cols*spiel.rows)
       System.out.println("Gewonnen");
   }
  
  // Falls das Feld schon aufgedeckt wurde, bricht die Rekursion ab, 
  // ansonsten wird das Feld aufgedeckt, d.h. die Anzahl der benachbarten Bomben 
  // in dem Button, der das Feld repräsentiert, angezeigt. Anschließend
  // wird die Funktion propagiere rekursiv auf den benachbarten Feldern aufgerufen.
  void propagiere()
   { if (istAufgedeckt) return;
     knopf.setText(""+benachbarteBomben);
     knopf.setStyle("-fx-background-color: #"+Integer.toHexString(240-benachbarteBomben*20)
          +Integer.toHexString(240-benachbarteBomben*20)+Integer.toHexString(240-benachbarteBomben*30));
     istAufgedeckt=true;
     spiel.aufgedeckteFelder++;             
     if (benachbarteBomben==0)                 
      { for(int i=Math.max(0,col-1);i<Math.min(spiel.cols,col+2);i++)
          for(int j=Math.max(0,row-1);j<Math.min(spiel.rows,row+2);j++)
              if(i!=col || j!=row) spiel.felder[i][j].propagiere();
      }
   }
       
  // Berechne für jedes Feld, wie viele seiner benachbarten Felder eine Bombe enthalten.
  // Da diese Funktion für jedes Feld aufgerufen wird, kann die Berechnung so erfolgen,
  // dass für jedes Feld, das eine Bombe enthält, bei allen benachbarten Feldern die
  // Variable benachbarteBomben um eins erhöht wird.
  void berechneBomben()
   { if (istBombe)
     { for(int i=Math.max(0,col-1);i<Math.min(spiel.cols,col+2);i++)
         for(int j=Math.max(0,row-1);j<Math.min(spiel.rows,row+2);j++)
             if(i!=col || j!=row) spiel.felder[i][j].benachbarteBomben++;
     }
    }
}  
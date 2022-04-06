package minenraeumerfx;

public class Feld
{ int col, row;
  Spiel spiel;
  boolean istBombe; 
  boolean istAufgedeckt=false;
  int benachbarteBomben;
  Knopf knopf;
  
  Feld(Spiel spiel, int col, int row)
   { this.col=col; 
     this.row=row;
     this.spiel=spiel;
     istBombe=(Math.random()<0.05);
     if (istBombe) spiel.anzahlBomben++;
     knopf = new Knopf(this);


   }

  
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
       

  void berechneBomben()
   { if (istBombe)
     { for(int i=Math.max(0,col-1);i<Math.min(spiel.cols,col+2);i++)
         for(int j=Math.max(0,row-1);j<Math.min(spiel.rows,row+2);j++)
             if(i!=col || j!=row) spiel.felder[i][j].benachbarteBomben++;
     }
    }
}  
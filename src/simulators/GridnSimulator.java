package simulators;
import gui.*;
import java.awt.Color;
import gui.Rectangle;
import grid.Grid;
import grid.cells.CellState;

public class GridnSimulator extends Grid implements Simulable
{
     public GUISimulator gui;

     public GridnSimulator(int l, int w,int n )
     {
          super(l,w,n);
          this.gui =  new GUISimulator (500 , 500 , Color . WHITE ) ;
     }


     private String Couleur(int e)
     {
          if (e==0) {return "#FEFEFE";}
          String c;
          if (e<6)
          {
               c = "#" + (String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0";
               return c;
          }
          if (e<10)
          {
                c = "#" + (String.valueOf(e)) + "0" +(String.valueOf(e)) + "0" +(String.valueOf(e)) + "0";
               return c;
          }
          else
          {
               c = "#" + (String.valueOf(3*e)) +"DF"  +(String.valueOf(3*e)) ;
              return c;
          }

     }
     @Override
     public void next()
     {
          int etat;
          this.gui.reset();
           //trouver une condition d'arret
			Grid temp = new Grid(this);

			for (int k=0; k<temp.getLength(); k++)
               {
				for (int l=0; l< temp.getWidth(); l++) {
					     etat =this.getCell(k, l).getCellState();
						if (temp.countStateK_1(k, l,etat) >= 3)
                              {
							this.setStateCell(k,l, (etat +1) % this.getn_State());
						}
                              this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30) );
                    }
			}

     }

     @Override
     public void restart()
     {
          this.gui.reset();
     }
}

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
          this.reInit();
          this.gui.reset();
     }
}

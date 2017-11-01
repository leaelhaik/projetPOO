package simulators;

import gui.*;
import java.awt.Color;
import gui.Rectangle;
import grid.Grid;
import grid.cells.CellState;

public class GridSimulator extends Grid implements Simulable
{
     public GUISimulator gui;

     public GridSimulator(int l, int w,int n )
     {
          super(l,w,2);
          this.gui =  new GUISimulator (500 , 500 , Color . WHITE ) ;
     }




     @Override
     public void next()
     {
          this.gui.reset();
           //trouver une condition d'arret
			Grid temp = new Grid(this);

			for (int k=0; k<temp.getLength(); k++) {
				for (int l=0; l< temp.getWidth(); l++) {

					if (this.getCell(k, l).getCellState() == 0) {
						if (temp.countStateK(k, l,1) == 3) {
							this.setStateCell(k,l, 1);
						}
					}
					if (this.getCell(k, l).getCellState() == 1) {
                              this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode("#4f77b6"),Color.decode("#4f77b6"),30) );
						if (temp.countStateK(k, l,1) != 3 && temp.countStateK(k,l,1) != 2) {
							this.setStateCell(k,l, 0);
						}
					}


				}
			}

     }

     @Override
     public void restart()
     {
          ;
     }
}

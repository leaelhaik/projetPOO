package simulators;

import gui.*;
import java.awt.Color;
import gui.Rectangle;
import grid.GridConway;
import grid.cells.*;

public class GridConwaySimulator extends GridConway implements Simulable
{
     public GUISimulator gui;

     public GridConwaySimulator(int l, int w)
     {
          super(l,w);
          this.gui =  new GUISimulator (500 , 500 , Color . WHITE ) ;
     }




     @Override
     public void next() {
    	 this.gui.reset();
    	 GridConway temp = new GridConway(this);

    	 	for (int k=0; k<temp.getLength(); k++) {
    	 		for (int l=0; l< temp.getWidth(); l++) {

    	 			if (this.getCell(k, l).getCellState() == CellState.DEAD) {
    	 				if (temp.countAlives(k, l) == 3) {
    	 					this.setStateCell(k,l, CellState.ALIVE);
    	 				}
    	 			}
    	 			if (this.getCell(k, l).getCellState() == CellState.ALIVE) {
    	 				this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode("#4f77b6"),Color.decode("#4f77b6"),30) );
    	 				if (temp.countAlives(k, l) != 3 && temp.countAlives(k,l) != 2) {
    	 					this.setStateCell(k,l, CellState.DEAD);
    	 				}
    			 	}


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

package simulators;
import gui.*;
import java.awt.Color;
import gui.Rectangle;
import grid.Grid;

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
			Grid temp = new Grid(this);        // On copie la grille car on ne peut modifier dynamiquement
			for (int k=0; k<temp.getLength(); k++)
               {
				for (int l=0; l< temp.getWidth(); l++) {
					     etat =this.getCell(k, l).getCellState();
						if (temp.countStateK_1(k, l,etat) >= 3) //compte les voisins vivant/morts
                              {
							this.setStateCell(k,l, (etat +1) % this.getn_State());//actualise l'état
						}
                              this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30) );
                    }
			}

     }

     @Override
     public void restart()
     {
          this.reInitgrid();
          this.gui.reset();
          int etat;
// On réaffiche tous les carrés
          for (int k=0; k<this.getLength(); k++)
          {
               for (int l=0; l< this.getWidth(); l++) {
                    etat =this.getCell(k, l).getCellState();
                    this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30) );
               }
          }

     }
}

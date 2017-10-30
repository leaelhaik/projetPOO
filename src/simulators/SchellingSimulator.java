package simulators;

import gui.*;
import java.awt.Color;
import gui.Rectangle;
import grid.Grid;
import grid.cells.Cell;
import grid.cells.CellState;
import grid.*;
import grid.GestionVacant;
import java.util.*;



public class SchellingSimulator extends GestionVacant implements Simulable
{
     public GUISimulator gui;
     private int seuil;

     public SchellingSimulator(int length, int width,int nbr_color,int k)
     {
          super(length,width,nbr_color);
          this.gui =  new GUISimulator (500 , 500 , Color . WHITE ) ;
          this.seuil=k;
     }


     @Override
     public void next()
     {
          Iterator<Cell> it;
          int etat;
          this.gui.reset();
          it = this.getVacants().iterator();
           //trouver une condition d'arret

			for (int k=0; k<this.getLength(); k++)
               {
				for (int l=0; l< this.getWidth(); l++) {

					     etat =this.getCell(k, l).getCellState();
                              if (etat !=0)
                              {


						       if (this.countVoisinMemeCouleur(k, l,etat) < 8-this.seuil)
                                     {
                                          Random logement = new Random();

                                          int nouveau_logement =logement.nextInt(this.lengthVacants());

                                          int k1 =(int)this.getCellVacant(nouveau_logement-1).getX();
                                          int l1 = (int)this.getCellVacant(nouveau_logement-1).getY();
                                          this.removeCell(this.getCellVacant(nouveau_logement-1));
                                          this.setStateCell(k1,l1,etat);
                                          this.setStateCell(k,l,0);
                                          this.ajoutCell(this.getCell(k,l));
                                          if (this.Est_Vacante(k1,l1))
                                          {
                                               System.out.println(k1+"/"+l1);
                                          }
                                          if (!this.Est_Vacante(k,l))
                                          {
                                               System.out.println("Ah non");
                                          }

                                          this.gui.addGraphicalElement( new Rectangle(30*k1+30,30*l1+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30));
                                          //this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode("#FFFFFF"),Color.decode("#FFFFFF"),30) );

                                     }
                              }
                              etat =this.getCell(k, l).getCellState();
                              this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30));
                         }
               }


     }


     @Override
     public void restart(){
          this.reInitVac();
          this.gui.reset();
          for (int k=0; k<this.getLength(); k++)
          {
               for (int l=0; l< this.getWidth(); l++){
                    int etat =this.getCell(k, l).getCellState();
                    this.gui.addGraphicalElement( new Rectangle(30*k+30,30*l+30,Color.decode(this.Couleur(etat)),Color.decode(this.Couleur(etat)),30) );
               }
          }
     }

}

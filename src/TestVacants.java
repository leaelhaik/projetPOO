
import grid.*;

import java.util.*;
import grid.Grid;
import grid.cells.Cell;
import grid.GestionVacant;

public class TestVacants
{
  public static void main ( String[] args ) {
       GestionVacant g = new GestionVacant(4,4,4);
       g.printVacant();
       for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                 System.out.println("(" + g.getCell(i,j).getX()+ ","+ g.getCell(i,j).getY() +")");
                 System.out.println("etat=" + g.getCell(i,j).getCellState());
            }
       }
       Random logement = new Random();

       int nouveau_logement =logement.nextInt(g.lengthVacants());
       System.out.println("Enlever cell n° = " + nouveau_logement);

       g.printVacant();
       System.out.println("ok");
       g.ajoutCell(g.getCell(1,3));
       g.printVacant();
       g.removeCell(g.getCell(1,3));
       g.printVacant();
      /* g.setStateCell((int)g.getCellVacant(nouveau_logement-1).getX(),(int)g.getCellVacant(nouveau_logement-1).getY(),6);
       for (int i=0;i<4;i++){
          for (int j=0;j<4;j++){
               System.out.println("(" + g.getCell(i,j).getX()+ ","+ g.getCell(i,j).getY() +")");
               System.out.println("etat=" + g.getCell(i,j).getCellState());
          }
     }
*/
 }
 }

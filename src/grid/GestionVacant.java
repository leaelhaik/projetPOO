package grid;
import java.util.*;
import grid.cells.Cell;
import grid.cells.CellState;
import grid.*;


public class GestionVacant extends Grid
{
     private LinkedList<Cell> vacants;
     public GestionVacant(int length, int width,int nbr_color)
     {
          super(length,width,nbr_color);
          this.vacants= new LinkedList<Cell>();
          this.GridMoinsZero();
          for (int i=0; i < length; i++) {
     		for (int j = 0; j < width; j++){
                    if (this.getCell(i,j).getCellState()==0){
                         this.vacants.add(this.getCell(i,j));
                    }
               }


          }
     }

     public LinkedList<Cell> getVacants()
     {
          return this.vacants;
     }
//Reinitialise la liste des vacants
     public void reInitVac()
     {
          this.reInitgrid();
          this.GridMoinsZero();
          LinkedList<Cell> newVacants = new LinkedList<Cell>();
          for (int i=0; i < this.getLength(); i++) {
     		for (int j = 0; j < this.getWidth(); j++){
                    if (this.getCell(i,j).getCellState()==0){
                         newVacants.add(this.getCell(i,j));
                    }
               }
          }
          this.vacants = newVacants;
     }



     public boolean Est_Vacante(int i,int j)
     {
          return (this.getCell(i,j).getCellState()==0);
     }

     public void ajoutCell(Cell c)
     {
          this.vacants.add(c);
     }

//Renvoit la cellule n°i de la liste

     public Cell getCellVacant(int i)
     {
          if (this.lengthVacants()<i)
          {
               throw new IllegalArgumentException("Cannot return that cell");
          }
          Iterator<Cell> it = this.vacants.iterator();
          Cell c;
          for (int k =0; k<i;k++)
          {
               c =it.next();
          }

          return it.next();
     }

//Affiche tous les vacants ( pour les tests )
     public void printVacant()
     {
          Cell e;
          Iterator<Cell> it = this.vacants.iterator();
          while (it.hasNext())
          {
               e = it.next();
               System.out.println("(" + e.getX()+ ","+ e.getY() +")");
          }
     }

     public int lengthVacants()
     {
          return this.vacants.size();
     }

     public void removeCell(Cell c)
     {
          Iterator<Cell> it = this.vacants.iterator();
          int i=0; Cell e =it.next();
          while(it.hasNext() && e!= c)
          {
               e = it.next();
               i++;
          }
          /*if (!it.hasNext())
          {
               throw new IllegalArgumentException("Cannot remove that cell");
          }*/
          it.remove();
     }
}

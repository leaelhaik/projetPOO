import gui.*;
import java.util.*;
import grid.*;

public class GestionVacant extends Grid
{
     private ArrayList<Cell> vacants;
     public GestionVacant(int length, int width,int nbr_color)
     {
          super(length,width,nbr_color);
          this.vacants= new ArrayList<Cell>();
          for (int i=0; i < length; i++) {
     		for (int j = 0; j < width; j++){
                    if (this.getCell(i,j).getCellState()==0){
                         this.vacant.add(this.getCell(i,j));
                    }
               }


     }

     public ArrayList<Cell> getVacants()
     {
          return this.vacants;
     }



     public boolean Est_Vacante(int i,int j)
     {
          return (this.getCell(i,j).getCellState()==0);
     }

}

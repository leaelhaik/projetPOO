import gui.* ;
import java.awt.Color ;
import grid.*;
import java.util.*;


public class TestGridnSimulator
{
  public static void main ( String[] args ) {
  System.out.println("Combien d'états ?");
  int n;
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  if (n<0) {throw new IllegalArgumentException("Le nombre d'état ne peut pas être négatif");}
  GridnSimulator g = new GridnSimulator(20,20,n);
  g.gui.setSimulable(g) ;

}

}

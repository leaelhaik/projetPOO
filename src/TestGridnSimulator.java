import gui.* ;
import java.awt.Color ;
import grid.*;
import java.util.*;
import simulators.GridnSimulator;


public class TestGridnSimulator
{
  public static void main ( String[] args ) {
  System.out.println("Combien d'états ?(entre 1 et 10)");
  int n;
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  if (n<0) {throw new IllegalArgumentException("Le nombre d'états ne peut pas être négatif");}
  if (n>10) {throw new IllegalArgumentException("Le nombre d'états est supérieur à celui autorisé");}
  GridnSimulator g = new GridnSimulator(20,20,n);
  g.gui.setSimulable(g) ;

}

}

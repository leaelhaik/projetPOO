import gui.* ;
import java.awt.Color ;
import grid.*;
import java.util.*;
import simulators.SchellingSimulator;


public class TestSchellingSimulator
{
  public static void main ( String[] args ) {
  System.out.println("Combien de couleurs ?");
  int n;
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  if (n<0) {throw new IllegalArgumentException("Le nombre de couleurs ne peut pas être négatif");}
  SchellingSimulator g = new SchellingSimulator(10,10,n,3);
  g.gui.setSimulable(g) ;

}

}

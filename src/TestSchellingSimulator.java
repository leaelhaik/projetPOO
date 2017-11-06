import gui.* ;
import java.awt.Color ;
import grid.*;
import java.util.*;
import simulators.SchellingSimulator;


public class TestSchellingSimulator
{
  public static void main ( String[] args ) {
  System.out.println("Combien de couleurs ? (entre 1 et 10)");
  int n;
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  if (n<0) {throw new IllegalArgumentException("Le nombre de couleurs ne peut pas être négatif");}
  if (n<0) {throw new IllegalArgumentException("Le nombre de couleurs est supérieur à celui autorisé");}
  int K;
  System.out.println("Seuil K ?");
  K = sc.nextInt();
  if (K<0) {throw new IllegalArgumentException("Le seuil ne peut pas être négatif");}
  SchellingSimulator g = new SchellingSimulator(20,20,n,K);
  g.gui.setSimulable(g) ;

}

}

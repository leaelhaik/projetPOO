import gui.* ;
import java.awt.Color ;
import java.util.*;

public class TestBallsSimulator
{
  public static void main ( String[] args ) {
  System.out.println("Combien de boules ?");
  int n;
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  if (n<0) {throw new IllegalArgumentException("Le nombre de boules ne peut pas être négatif");}
  BallsSimulator b = new BallsSimulator(n);
  b.gui.setSimulable ( b ) ;

}

}

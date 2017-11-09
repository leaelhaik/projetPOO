import gui.* ;
import simulators.BoidsSimulator;
import java.util.Scanner;
import java.awt.Color ;
//PERMET D'AFFICHER LES BOIDS SUR LA SIMULATION GRAPHIQUE
public class TestBoidsSimulator
{
  public static void main ( String[] args ) {
  Scanner sc = new Scanner(System.in);
  System.out.println("\n Il y a dans ce simulateur 3 types de boids, des gros, des moyens et des petits. \n Les gros chassent les moyens et les moyens chassent les petits mais les gros ne chassent pas les petits. \n");
  System.out.println("Veuillez saisir le nombre de Proies :");
  int nbPreys = sc.nextInt();
  if (nbPreys<0) {throw new IllegalArgumentException("Le nombre de Proies ne peut pas être négatif");}
  System.out.println("Veuillez saisir le nombre de boids de taille moyenne :");
  int nbMiddle = sc.nextInt();
  if (nbMiddle<0) {throw new IllegalArgumentException("Le nombre de poissons de taille moyenne ne peut pas être négatif");}
  System.out.println("Veuillez saisir le nombre de Prédateurs :");
  int nbPredators = sc.nextInt();
  if (nbPredators<0) {throw new IllegalArgumentException("Le nombre de Predateurs ne peut pas être négatif");}
  BoidsSimulator b = new BoidsSimulator(nbPredators,nbPreys,nbMiddle);
  b.gui.setSimulable(b);
  }
}

import gui.* ;
import simulators.BoidsSimulator;

import java.awt.Color ;
//PERMET D'AFFICHER LES BOIDS SUR LA SIMULATION GRAPHIQUE
public class TestBoidsSimulator
{
  public static void main ( String[] args ) {
  BoidsSimulator b = new BoidsSimulator(2,50);
  b.gui.setSimulable ( b ) ;

}

}

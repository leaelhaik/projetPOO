import gui.*;
import grid.*;
import simulators.GridConwaySimulator;

public class TestGridConwaySimulator {
	  public static void main ( String[] args ) {
		  GridConwaySimulator g = new GridConwaySimulator(20,20);
		  g.gui.setSimulable(g) ;
	  }
}

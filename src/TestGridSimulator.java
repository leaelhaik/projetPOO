import gui.* ;
import java.awt.Color ;
import grid.*;


public class TestGridSimulator
{
  public static void main ( String[] args ) {
  GridSimulator g = new GridSimulator(20,20,2);
  g.gui.setSimulable(g) ;

}

}

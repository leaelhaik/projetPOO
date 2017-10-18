import gui.GUISimulator ;
import java.awt.Color ;

public class TestBallsSimulator
{
  public static void main ( String[] args ) {
  GUISimulator gui = new GUISimulator (500 , 500 , Color . BLACK ) ;
  BallsSimulator b = new BallsSimulator(4);
  gui.setSimulable ( b ) ;
  


}

}

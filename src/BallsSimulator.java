import gui.*;
import java.awt.Color;
import gui.Oval;
import java.util.Random;

public class BallsSimulator extends Balls implements Simulable
{

  public Balls pointsSimulables;
  public GUISimulator gui;
  public int[] direction;

  public BallsSimulator(int nb)
  {
    super(nb);
    this.gui =  new GUISimulator (500 , 500 , Color . BLACK ) ;


  }


@Override
public void next ()
{
     //System.out.println(this.toString());
  this.gui.reset();
  for(int i=0;i<this.getlength();i++)
  {
    this.trans(1,1);
    this.gui.addGraphicalElement( new Oval(this.gettabi(i).x, this.gettabi(i).y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),20) );
  }

}

@Override
public void restart ()
{
  this.reInit();
  System.out.println(this.toString());
  this.gui.reset();
  for(int i=0;i<this.getlength();i++)
  {
    this.gui.addGraphicalElement( new Oval(this.gettabi(i).x, this.gettabi(i).y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),10) );
  }

}
}

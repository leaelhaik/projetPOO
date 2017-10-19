import gui.*;
import java.awt.Color;

public class BallsSimulator extends Balls implements Simulable
{

  public Balls pointsSimulables;
  public GUISimulator gui;

  public BallsSimulator(int nb)
  {
    super(nb);
    this.gui =  new GUISimulator (500 , 500 , Color . BLACK ) ;

  }

@Override
public void next ()
{
  this.translate(10,10);
  System.out.println(this.toString());
  this.gui.reset();
  for(int i=0;i<this.tab.length;i++)
  {
    this.gui.addGraphicalElement( new Rectangle(this.tab[i].x, this.tab[i].y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),10) );
  }

}

@Override
public void restart ()
{
  this.reInit();
  System.out.println(this.toString());
  this.gui.reset();
  for(int i=0;i<this.tab.length;i++)
  {
    this.gui.addGraphicalElement( new Rectangle(this.tab[i].x, this.tab[i].y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),10) );
  }

}




}

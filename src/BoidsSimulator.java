import gui.*;
import java.awt.Color;

public class BoidsSimulator extends Boids implements Simulable
{

  EventManager e;
  MoveBoidsEvent m;
  public GUISimulator gui;

  public BoidsSimulator(int nb)
  {
    super(nb);
    this.gui =  new GUISimulator (1500 , 1500 , Color . BLACK ) ;
    this.e = new EventManager(0);
    this.m = new MoveBoidsEvent(0,this);
    e.addEvent(m);

  }

  @Override
  public void next ()
  {
    this.e.next();
    System.out.println( this.toString());
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
      this.e.restart();
    }

}
 }

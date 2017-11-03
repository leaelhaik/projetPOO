package simulators;
import events.*;
import gui.*;
import java.awt.Color;
import boids.*;

public class BoidsSimulator extends BoidsNew implements Simulable
{

  EventManager e;
  MovePreys m;
  MovePredators n;
  public GUISimulator gui;

  public BoidsSimulator(int nbPredators, int nbPreys)
  {
    super(nbPredators,nbPreys);
    this.gui =  new GUISimulator (1400 , 900 , Color . BLACK ) ;
    this.e = new EventManager(0, this);

  }

  @Override
  public void next ()
  {
    this.e.next();
    System.out.println( this.toString());
    System.out.println(e.toString());
    this.gui.reset();
    for(int i=0;i<this.PreysTab.length;i++)
    {
      this.gui.addGraphicalElement( new Rectangle(this.PreysTab[i].x, this.PreysTab[i].y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),2) );
    }
    for(int i=0; i<this.PredatorsTab.length ;i++)
    {
      this.gui.addGraphicalElement( new Rectangle(this.PredatorsTab[i].x, this.PredatorsTab[i].y,Color.decode("#00ff00"),Color.decode("#00ff00"),5) );
    }
  }


  @Override
  public void restart ()
  {
    this.reInitBoids();
    System.out.println(this.toString());
    this.gui.reset();
    for(int i=0;i<this.PreysTab.length;i++)
    {
      this.gui.addGraphicalElement( new Rectangle(this.PreysTab[i].x, this.PreysTab[i].y,Color.decode("#1f77b4"),Color.decode("#1f77b4"),2) );
    }
    for(int i=0; i<this.PredatorsTab.length ;i++)
    {
      this.gui.addGraphicalElement( new Rectangle(this.PredatorsTab[i].x, this.PredatorsTab[i].y,Color.decode("#00ff00"),Color.decode("#00ff00"),5) );
    }
    this.e.restart();
    this.e.addEvent(new MovePreys(0,this));
    this.e.addEvent(new MovePredators(0,this));

}
 }

package events;

import events.Event;
import boids.*;

public class MovePreys extends Event
{

  public BoidsNew boids;

  public MovePreys(int date, BoidsNew boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute() // réécriture de la méthode
  {
    this.boids.movePreys(); // l'evenement fait bouger les proies
  }




}

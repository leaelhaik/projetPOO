package events;

import events.Event;
import boids.*;

public class MoveMiddle extends Event
{

  public Boids boids;

  public MoveMiddle(int date, Boids boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute() // réécriture de la méthode
  {
    this.boids.moveMiddle(); // l'evenement fait bouger les predateurs
  }




}

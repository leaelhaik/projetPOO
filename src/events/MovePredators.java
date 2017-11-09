package events;

import events.Event;
import boids.*;

public class MovePredators extends Event
{

  public Boids boids;

  public MovePredators(int date, Boids boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute() // réécriture de la méthode
  {
    this.boids.movePredators(); // l'evenement fait bouger les predateurs
  }




}

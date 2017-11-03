package events;

import events.Event;
import boids.BoidsNew;

public class MovePredators extends Event
{

  public BoidsNew boids;

  public MovePredators(int date, BoidsNew boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute()
  {
    this.boids.movePredators();
  }




}

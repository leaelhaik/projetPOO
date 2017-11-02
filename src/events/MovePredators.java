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
  public int getDate()
  {
    return this.date;
  }

  public void execute()
  {
    this.boids.movePredators();
  }




}

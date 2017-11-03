package events;

import events.Event;
import boids.BoidsNew;

public class MoveBoidsEvent extends Event
{

  public BoidsNew boids;

  public MoveBoidsEvent(int date, BoidsNew boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute()
  {
    this.boids.moveBoids();
  }
}

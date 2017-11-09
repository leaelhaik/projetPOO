package events;

import events.Event;
import boids.Boids;

public class MoveBoidsEvent extends Event
{

  public Boids boids;

  public MoveBoidsEvent(int date, Boids boids)
  {
    super(date);
    this.boids = boids;
  }

  public void execute()
  {
    this.boids.moveBoids();
  }
}

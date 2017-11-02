package events;

import events.Event;
import boids.BoidsNew;

public class MovePreys extends Event
{

  public BoidsNew boids;

  public MovePreys(int date, BoidsNew boids)
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
    this.boids.movePreys();
  }




}

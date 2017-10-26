
public class MoveBoidsEvent extends Event
{

  public Boids boids;

  public MoveBoidsEvent(int date, Boids boids)
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
    this.boids.moveBoids();
  }




}
